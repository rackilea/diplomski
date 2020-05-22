mPositionHandle = GLES30.glGetAttribLocation(mProgram, "aPosition");
mColorHandle    = GLES30.glGetAttribLocation(mProgram, "aColor");

GLES30.glEnableVertexAttribArray(mPositionHandle);
GLES30.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES30.GL_FLOAT, false, vertexStride, vertexBuffer);

GLES30.glEnableVertexAttribArray(mColorHandle);
GLES30.glVertexAttribPointer(mColorHandle, 4, GLES30.GL_FLOAT, false, 0, colorBuffer);

GLES30.glDrawArrays(GLES30.GL_LINES, 0, vertexBufferSize / 4 / COORDS_PER_VERTEX);
GLES30.glDisableVertexAttribArray(mPositionHandle);
GLES30.glDisableVertexAttribArray(mColorHandle);