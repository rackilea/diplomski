int textureTexUnitIndex = 1;
GLES20.glActiveTexture( GLES20.GL_TEXTURE1 ); // GLES20.GL_TEXTURE1 <--> textureTexUnitIndex
GLES20.glBindTexture( GLES20.GL_TEXTURE_2D, textureHandle[textureIndex] );

int maskTexUnitIndex = 2;
GLES20.glActiveTexture( GLES20.GL_TEXTURE2 ); // GLES20.GL_TEXTURE2 <--> maskTexUnitIndex
GLES20.glBindTexture( GLES20.GL_TEXTURE_2D, ... ) // <-- here you have to add the texture handler of the texture