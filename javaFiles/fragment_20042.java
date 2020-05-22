import java.io.IOException;
import java.nio.ByteBuffer;

public class Q45235042 {

   public static String toEbcdic( String strToConvert ) throws IOException {
      String[] test = strToConvert.split( "(?<=\\G..)" );
      ByteBuffer sb = ByteBuffer.allocate( test.length );
      for ( String s : test )
         sb.put( (byte) Short.parseShort( s, 16 ) );
      return new String( sb.array(), "CP1047");
   }

   public static void main( String[] args ) throws IOException {
      System.out.println( toEbcdic( "C120C2" ) );
   }
}