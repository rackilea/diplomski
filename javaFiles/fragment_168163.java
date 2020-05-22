private static int f( int[][] arr, int row, int prevCol ) {
    if ( row == arr.length ) return 0;

    int C = arr[row].length;
    if ( dp[row][prevCol+1] != Integer.MAX_VALUE ) return dp[row][prevCol+1];
    int res = Integer.MAX_VALUE;
    for ( int j = 0; j < C; j++ ) {
      if ( j != prevCol ) {
        int val = arr[row][j] + f ( arr, row + 1, j );
        res = Math.min ( res, val );
      }
    }
    dp[row][prevCol+1] = res;
    return res;
  }