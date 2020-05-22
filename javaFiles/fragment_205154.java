// Create Vertex Array.
gl.glGenVertexArrays(1, vertexArray);
gl.glBindVertexArray(vertexArray.get(0));

// Specify how data should be sent to the Program.

// VertexAttribArray 0 corresponds with location 0 in the vertex shader.
gl.glEnableVertexAttribArray(0);
gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, buffers.get(0));
gl.glVertexAttribPointer(0, 2, GL.GL_FLOAT, false, 0, 0);

// VertexAttribArray 1 corresponds with location 1 in the vertex shader.
gl.glEnableVertexAttribArray(1);
gl.glBindBuffer(GL2.GL_ARRAY_BUFFER, buffers.get(1));
gl.glVertexAttribPointer(1, 3, GL.GL_FLOAT, false, 0, 0);