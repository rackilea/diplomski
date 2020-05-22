public void draw(float[] cameraView, float[] cameraPerspective, float lightIntensity) {

    .....

    Matrix.multiplyMM(modelViewMatrix, 0, cameraView, 0, modelMatrix, 0);
    Matrix.multiplyMM(modelViewProjectionMatrix, 0, cameraPerspective, 0, modelViewMatrix, 0);


    if(this.movable==true) {
        Matrix.setRotateM(mRotationMatrix, 0, FactorsClass.rotateF, 0.0f, 1.0f, 0.0f);
    }
    Matrix.multiplyMM(mFinalModelViewProjectionMatrix, 0, modelViewProjectionMatrix, 0, mRotationMatrix, 0);

    .....

    GLES20.glUniformMatrix4fv(modelViewProjectionUniform, 1, false, mFinalModelViewProjectionMatrix, 0);

    .....
}