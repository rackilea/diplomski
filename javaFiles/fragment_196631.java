public static double changeEndian( double x ) {
      ByteBuffer cv = ByteBuffer.allocate( 8 ).putDouble( x );
      cv.order( ByteOrder.LITTLE_ENDIAN );
      cv.rewind();
      return cv.getDouble();
}