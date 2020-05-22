public class Version implements Comparable<Version> {

   public final int     major;
   public final Integer minor;
   public final Integer patch;

   public Version( String ver ) {
      final String[] parts = ver.split("\\.");
      this.major = Integer.parseInt( parts[0] );
      if( parts.length > 1 ) {
         this.minor = Integer.parseInt( parts[1] );
         if( parts.length > 2 ) {
            this.patch = Integer.parseInt( parts[2] );
         }
         else {
            this.patch = null;
         }
      }
      else {
         this.minor = null;
         this.patch = null;
      }
   }

   @Override
   public int compareTo( Version right ) {
      int diff = this.major - right.major;
      if( diff != 0 ) {
         return diff;
      }
      if( this.minor == null && right.minor == null ) {
         return 0;
      }
      if( this.minor == null && right.minor != null ) {
         return -1;
      }
      if( this.minor != null && right.minor == null ) {
         return +1;
      }
      diff = this.minor - right.minor;
      if( diff != 0 ) {
         return diff;
      }
      if( this.patch == null && right.patch == null ) {
         return 0;
      }
      if( this.patch == null && right.patch != null ) {
         return -1;
      }
      if( this.patch != null && right.patch == null ) {
         return +1;
      }
      diff = this.patch - right.patch;
      return diff;
   }

   @Override
   public String toString() {
      return String.format( "%d.%d.%d", major, minor, patch );
   }

   public static void main( String[] args ) {
      final List<Version> versions = new ArrayList<>( 20 );
      versions.add( new Version( "5.3" ));
      versions.add( new Version( "5.3.0" ));
      versions.add( new Version( "2.5" ));
      versions.add( new Version( "2.5.100" ));
      final Random r = new Random( System.currentTimeMillis());
      for( int i = 0; i < 20; ++i ) {
         final int maj = r.nextInt(  10 );
         final int min = r.nextInt(  10 );
         final int pat = r.nextInt( 100 );
         final Version v =
            new Version( String.format( "%d.%d.%d", maj, min, pat ));
         versions.add( v );
      }
      Collections.sort( versions );
      versions.forEach( System.err::println );
   }
}