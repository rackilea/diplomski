int color_loc = GLES30.glGetUniformLocation(mProgram, "vColor")
GLES30.glUseProgram(mProgram);
GLES30.glUniform4f(color_loc, 1.0, 0.0, 0.0, 1.0); // red  

mPositionHandle = GLES30.glGetAttribLocation(mProgram, "vPosition");
GLES30.glEnableVertexAttribArray(mPositionHandle);
GLES30.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES30.GL_FLOAT, false, vertexStride, vertexBuffer);

GLES30.glDrawArrays(GLES30.GL_LINES, 0, vertexBufferSize / 4 / COORDS_PER_VERTEX);
GLES30.glDisableVertexAttribArray(mPositionHandle);