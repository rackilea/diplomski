class Arrayofhope
{

   public static void main( String[] args )
   {
      char[] leta = new char[ 26 ];
      char letterA = 'a';
      char letterZ = 'z';
      for( int i = letterA; i <= letterZ; i++ ) {
         System.out.print( (char) i );
         leta[i-'a'] = (char)i;
      }
   }
}