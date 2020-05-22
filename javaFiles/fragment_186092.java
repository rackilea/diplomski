public static int[] sumColumns(int[][] vals) {
      // compute the maximum row length (most columns)
      int maxColumns = 0;
      for (int r = 0; r < vals.length; r++) {
         maxColumns = Math.max(maxColumns, vals[r].length);
      }

      // use that to initialize the return array
      int[] sums = new int[maxColumns];

      //now just iterate over the rows and columns
      // calculating the sum.  
      for (int r = 0; r < vals.length; r++) {
         for (int c = 0; c < vals[r].length; c++) {
            sums[c] += vals[r][c];
         }
      }
      return sums;
   }