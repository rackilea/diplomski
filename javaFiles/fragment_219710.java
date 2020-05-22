// make sure factor is not 0 before you do this
for (int col = 0; col < pixels[0].length; col++) {
   for(int i=0; i<factor; i++) {
       pixelStretch[row][col*factor+i] = pixels[row][col];
   }
}