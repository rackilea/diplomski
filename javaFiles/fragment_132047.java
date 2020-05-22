GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo);
GLES20.glBufferData(
    GLES20.GL_ARRAY_BUFFER,
    vertexBuffer.capacity() * 4, // 4 = bytes per float
    vertexBuffer,
    GLES20.GL_STATIC_DRAW);
GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);

GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, ibo);
GLES20.glBufferData(
    GLES20.GL_ELEMENT_ARRAY_BUFFER,
    drawListBuffer.capacity() * 2, // 2 = bytes per short
    drawListBuffer,
    GLES20.GL_STATIC_DRAW);
GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);