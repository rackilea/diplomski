sumLeft = 0;
 sumRight = 0;
 sumTop = 0;
 sumBottom = 0;
 sumDiagonalUp = 0;
 sumDiagonalDown = 0;
 for(int i = 0; i < mSqr.length; i++) {
     for(int j = 0; j < mSqr[i].length; j++) {
         if (i == 0) {
            sumLeft += mSqr[i][j];
         }
         if (i == mSqr.length - 1) {
            sumRight += mSqr[i][j];
         }
         if (j == 0) {
            sumTop += mSqr[i][j];
         }
         if (j == mSqr[i].length) {
            sumBottom += mSqr[i][j];
         }
         if (i == j) {
            sumDiagonalDown += mSqr[i][j];
         }
         if (i + j == mSqr.length - 1) {
            sumDiagonalUp += mSqr[i][j];
         }
     }
 }