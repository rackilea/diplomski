public static int count( int n ){
   if ( n == 1)
   {
      System.out.printf( "%15d", 1);
      return 1;
   }

   int nTerms = 2 * count ( n - 1 );
   System.out.printf( "%15d", nTerms );

   return nTerms;
}