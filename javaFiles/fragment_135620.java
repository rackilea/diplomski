for (int i=w-1; i<w+2; ++i) {
   if (i<0 || i>=255) continue;
   for (int j=h-1; j<h+3; ++j) {
       if (j<0 || j>=255) continue;
       if (i==w && j==h) continue;
       neighboringPixels.add(imageMatrix[i][j]);
   }