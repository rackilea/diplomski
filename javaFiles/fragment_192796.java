int kernel_rows = 3;
   int kernel_cols = 3;

   // define kernel here (double loop), these are the 1/16, 2/16, etc...
   // values that you're multiplying the image pixels by
   double[][] kernel = ... 

   // iterate over each pixel in the image
   // leave a kernel_rows/2 sized gap around the edge of the image
   // so that we don't run into IndexOutOfBounds exceptions
   // when performing the convolution
   for (int row = kernel_rows/2; row < pi.getHeight() - kernel_rows/2; row ++) {
     for (int col = kernel_cols/2; col < pi.getWidth() - kernel_cols/2; col++) {

       int r = 0;
       int g = 0;
       int b = 0;

       // iterate over each pixel in the kernel
       for (int row_offset = 0 ; row_offset < kernel_rows ; row_offset++ ) {
         for (int col_offset = 0 ; col_offset < kernel_cols ; col_offset++ ) {

           // subtract by half the kernel size to center the kernel
           // on the pixel in question
           int row_index = row + row_offset - kernel_row/2;
           int col_index = col + col_offset - kernel_cols/2

           r += data[row_index][col_index].red * kernel[row_offset][col_offset];
           g += data[row_index][col_index].green * kernel[row_offset][col_offset];
           b += data[row_index][col_index].blue * kernel[row_offset][col_offset];

         }
       }

     data[row][col] = new Pixel( r, g, b );

     }
   }