public class Filterable<T> {

   private List<T> source

   public Filterable(List<T> aSource) { source = aSource; }

   public List<T> filter( Filter<T> aFilter ) {
       List<T> dest = new ArrayList<T>();
       for( T current : source ) {
           if( filter.contains(current) ) {
              dest.add( current );
           }
       }
       return dest;
   } 

   public static void main(String[] args) {
      String message = "V ubcr guvf vfa'g ubzrjbex orpnhfr ";
      message += "V tbg vg bss fgnpxbiresybj: ";
      message += "uggc://fgnpxbiresybj.pbz/dhrfgvbaf/21664702/wnin-frnepu-na-vagrtre-neenl-sbe-yvfg-bs-enaqbz-inyhrf";

      Filterable f1 = new Filterable( Arrays.asList( 6, 4, 1, 1, 2 ) );
      Filterable f2 = new Filterable( Arrays.asList( 6, 3, 1, 5, 4 ) );
      Filterable f3 = new Filterable( Arrays.asList( 6, 4, 1, 6, 5, 4 ) );

      List<Integer> r1 = f1.filter( new OrderedFilter( 6, 5, 4 ) );
      List<Integer> r2 = f2.filter( new OrderedFilter( 6, 5, 4 ) );
      List<Integer> r3 = f3.filter( new OrderedFilter( 6, 5, 4 ) );

      print( r1 );
      print( r2 );
      print( r3 );
      System.out.println(rot13(message));
   }

   public static void print(List<Object> r1) {
      boolean first = true;
      for( Object o : r1 ) {
         if( !first ) System.out.print(", ");
         System.out.printf( "%s", o );
         first = false;
      }
      System.out.println();
   }

   public static String rot13(String input) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
         char c = input.charAt(i);
         if       (c >= 'a' && c <= 'm') c += 13;
         else if  (c >= 'A' && c <= 'M') c += 13;
         else if  (c >= 'n' && c <= 'z') c -= 13;
         else if  (c >= 'N' && c <= 'Z') c -= 13;
         sb.append(c);
      }
      return sb.toString();
   }
}

public interface Filter<T> {
   public boolean contains(T object);
}

public OrderedFilter implements Filter<T> {
   private T[] lookForThese;
   private int currentMatch = 0;

   public OrderedFilter( T... values ) {
      lookForThese = values;
   }

   public boolean contains(T current) {
      if( currentMatch >= lookForThese.length ) return false;
      if( lookForThese[currentMatch].equals( current ) ) {
         currentMatch++;
         return true;
      }
      return false;
   }
}