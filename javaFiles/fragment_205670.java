// Iterate through all k movements
for (i = 0; i < arrTime.length - 1; i++) {
   // Move by 1 second until reach next instruction
   for (j = arrTime[i]; j < arrTime[i + 1]; j++) {
      // South East
      if (arrDirection[i].equals("SE")) {
         // Check #1 above (a valid matrix position)
         if (nCurrRow < n - 1 && nCurrCol < n - 1) {
            // Check #2 above (only move into unvisited position)
            if (cell[nCurrRow+1][nCurrCol+1] == 0) {
               // Move, and record that cell has been visited
               nCurrRow++;
               nCurrCol++;
               cell[nCurrRow][nCurrCol] = 1;
            }
         }
      }
      // Other directions following the template for South East