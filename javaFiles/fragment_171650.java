public void setMatrixArray(boolean transposed, Matrix4f[] matrices){

    FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16*matrices.length);
    for(int i = 0; i<matrices.length; i++)  {
        matrices[i].store(matrixBuffer);
    }
    matrixBuffer.flip();
    GL20.glUniformMatrix4(testMat,transposed,matrixBuffer);
}