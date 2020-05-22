private final FloatBuffer buffer = EngineUtil.createBuffer( 16 );

      /**
    * @return Current modelview matrix (column-major)
    */
   public Matrix getModelviewMatrix() {
      return getMatrix( GL11.GL_MODELVIEW_MATRIX );
   }

   /**
    * @return Current projection matrix (column-major)
    */
   public Matrix getProjectionMatrix() {
      return getMatrix( GL11.GL_PROJECTION_MATRIX );
   }

   /**
    * Retrieves the specified matrix.
    * @param name Matrix name
    */
   private Matrix getMatrix( int name ) {
      // Retrieve specified matrix buffer
      buffer.rewind();
      GL11.glGetFloat( name, buffer );

      // Convert to array
      final float[] array = new float[ 16 ];
      buffer.get( array );

      // Convert to matrix
      return new Matrix( array );
   }