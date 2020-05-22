public static void modifyArray( int array2[] ) 
   {
      array2 = new int[10];
      //Copy only ten elements from outer array, which populates element at index 2.
      for ( int counter = 0; counter < array2.length; counter++ )
      array2[ counter ] *= 2;
   }