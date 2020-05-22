for (int i = 1; i < n; i++) 
{
 for (int j = 0; j < m; j++) 
 {
     int min = Integer.MAX_INT;
     for (int k = 0; k < m; k++) 
      {
        if ((a[ i ][ j ] + b[ k ][ j ] + c[ i-1 ][ k ]) < min) 

             min= a[ i ][ j ] + b[ k ][ j ] + c[ i-1 ][ k ];

      }//try every VM

     c[ i ][ j ] = min;

  }//for every VM
}//for every process