#loop

GLClear()

updateVideoTexture()

drawFrame(){
   drawVideo()
   drawBitmap()
}
drawVideo(){

    bindYourActiveTextureToVideo()

    setYourVertexAttribAndUniform()

    GLES20.glDrawArrays()

}

drawBitmap() {

    bindYourActiveTextureToBitmap()

    setYourVertexAttribAndUniform() // This should be the same as above for video
    // Considering you want to draw above your video, consider activating the blending for transparency :

    GLES20.glEnable(GLES20.GL_BLEND);
    GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA);

    GLES20.glDrawArrays()

}