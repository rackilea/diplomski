for (int row = 0; row < pixels.length / 2; row++){       
  for (int col = 0; col < pixels[0].length; col++){                 
      topPixel = pixels[row][col];  
      bottomPixel = pixels[(pixels.length - 1) - i][col];       
      bottomPixel.setColor(topPixel.getColor());       
  }     
}