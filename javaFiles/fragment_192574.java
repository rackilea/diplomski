private Mat overtrayImage( Mat background, Mat foreground ) {
  // The background and the foreground are assumed to be of the same size.
  Mat destination = new Mat( background.size(), background.type() );

  for ( int y = 0; y < ( int )( background.rows() ); ++y ) {
    for ( int x = 0; x < ( int )( background.cols() ); ++x ) {     
      double b[] = background.get( y, x );
      double f[] = foreground.get( y, x );

      double alpha = f[3] / 255.0;

      double d[] = new double[3];
      for ( int k = 0; k < 3; ++k ) {
        d[k] = f[k] * alpha + b[k] * ( 1.0 - alpha );
      }

      destination.put( y, x, d );
    }
  } 

  return destination;
}