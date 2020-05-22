public static void readImage(BufferedImage img, int array[][], int nrows, int ncols) {
      for (int i = 0; i < nrows; i++)
           for (int j = 0; j < ncols; j++) {
                int rgb = img.getRGB(j, i);
                int red = rgb >> 16 & 0xFF;
                int green = rgb >> 8 & 0xFF;
                int blue = rgb & 0xFF;
                array[i][j] = (int) (0.299*((double)red) + 0.587*((double)green) + 
                               0.114*((double)blue) );
           }
}