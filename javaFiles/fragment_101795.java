import java.awt.Point;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Crossword {

   public static void main ( String[] args ) {
      new Crossword( Arrays.asList( "5 4 4\n#_#_#\n_____\n#_##_\n#_##_\ntuna\nmusic\ncan\nhi".split( "\n" ) ) );
      new Crossword( Arrays.asList( "6 6 4\n##_###\n#____#\n___#__\n#_##_#\n#____#\n##_###\nnice\npain\npal\nid".split( "\n" ) ) );
   }

   private final int height, width; // Board size
   private final char[] board; // Current board state.  _ is unfilled.  # is blocked.  other characters are filled.
   private final Set<String> words; // List of words
   private final Map<Point, Integer> vertical = new HashMap<>(), horizontal = new HashMap<>();  // Vertical and horizontal slots

   private String indent = ""; // For formatting log
   private void log ( String message, Object... args ) { System.out.println( indent + String.format( message, args ) ); }

   private Crossword ( List<String> lines ) {
      // Parse input data
      final int[] sizes = Stream.of( lines.get(0).split( "\\s+" ) ).mapToInt( Integer::parseInt ).toArray();
      width = sizes[0];  height = sizes[1];
      board = String.join( "", lines.subList( 1, height+1 ) ).toCharArray();
      words = new HashSet<>( lines.subList( height+1, lines.size() ) );
      // Find horizontal slots then vertical slots
      for ( int y = 0, size ; y < height ; y++ )
         for ( int x = 0 ; x < width-1 ; x++ )
            if ( isSpace( x, y ) && isSpace( x+1, y ) ) {
               for ( size = 2 ; x+size < width && isSpace( x+size, y ) ; size++ ); // Find slot size
               horizontal.put( new Point( x, y ), size );
               x += size; // Skip past this horizontal slot
            }
      for ( int x = 0, size ; x < width ; x++ )
         for ( int y = 0 ; y < height-1 ; y++ )
            if ( isSpace( x, y ) && isSpace( x, y+1 ) ) {
               for ( size = 2 ; y+size < height && isSpace( x, y+size ) ; size++ ); // Find slot size
               vertical.put( new Point( x, y ), size );
               y += size; // Skip past this vertical slot
            }
      log( "A " + width + "x" + height + " board, " + vertical.size() + " vertical, " + horizontal.size() + " horizontal." );
      // Solve the crossword, horizontal first then vertical
      final boolean solved = solveHorizontal();
      // Show board, either fully filled or totally empty.
      for ( int i = 0 ; i < board.length ; i++ ) {
         if ( i % width == 0 ) System.out.println();
         System.out.print( board[i] );
      }
      System.out.println( solved ? "\n" : "\nNo solution found\n" );
   }

   // Helper functions to check or set board cell
   private char get ( int x, int y ) { return board[ y * width + x ]; }
   private void set ( int x, int y, char character ) { board[ y * width + x ] = character; }
   private boolean isSpace ( int x, int y ) { return get( x, y ) == '_'; }

   // Fit all horizontal slots, when success move to solve vertical.
   private boolean solveHorizontal () {
      return solve( horizontal, this::fitHorizontal, "horizontally", this::solveVertical );
   }
   // Fit all vertical slots, report success when done
   private boolean solveVertical () {
      return solve( vertical, this::fitVertical, "vertically", () -> true );
   }

   // Recur each slot, try every word in a loop.  When all slots of this kind are filled successfully, run next stage.
   private boolean solve ( Map<Point, Integer> slot, BiFunction<Point, String, Boolean> fill, String dir, Supplier<Boolean> next ) {
      if ( slot.isEmpty() ) return next.get(); // If finished, move to next stage.
      final Point pos = slot.keySet().iterator().next();
      final int size = slot.remove( pos );
      final char[] state = board.clone();
      /* Try each word */                                                   indent += "  ";
      for ( String word : words ) {
         if ( word.length() != size ) continue;
         /* If the word fit, recur. If recur success, done! */              log( "Trying %s %s at %d,%d", word, dir, pos.x, pos.y );
         if ( fill.apply( pos, word ) && solve( slot, fill, dir, next ) )
            return true;
         /* Doesn't match. Restore board and try next word */               log( "%s failed %s at %d,%d", word, dir, pos.x, pos.y );
         System.arraycopy( state, 0, board, 0, board.length );
      }
      /* No match.  Restore slot and report failure */                      indent = indent.substring( 0, indent.length() - 2 );
      slot.put( pos, size );
      return false;
   }

   // Try fit a word to a slot.  Return false if there is a conflict.
   private boolean fitHorizontal ( Point pos, String word ) {
      final int x = pos.x, y = pos.y;
      for ( int i = 0 ; i < word.length() ; i++ ) {
         if ( ! isSpace( x+i, y ) && get( x+i, y ) != word.charAt( i ) ) return false; // Conflict
         set( x+i, y, word.charAt( i ) );
      }
      return true;
   }
   private boolean fitVertical ( Point pos, String word ) {
      final int x = pos.x, y = pos.y;
      for ( int i = 0 ; i < word.length() ; i++ ) {
         if ( ! isSpace( x, y+i ) && get( x, y+i ) != word.charAt( i ) ) return false; // Conflict
         set( x, y+i, word.charAt( i ) );
      }
      return true;
   }
}