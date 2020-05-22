GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo);
GLES20.glVertexAttribPointer(
        mPositionHandle, 3,
        GLES20.GL_FLOAT, false,
        0, 0);                        // <----- 0, because "vbo" is bound
GLES20.glEnableVertexAttribArray(mPositionHandle);

GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, ibo);
GLES20.glDrawElements(
    GLES20.GL_TRIANGLES, indices.length,
    GLES20.GL_UNSIGNED_SHORT, 0);     // <----- 0, because "ibo" is bound

GLES20.glDisableVertexAttribArray(mPositionHandle);
GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);