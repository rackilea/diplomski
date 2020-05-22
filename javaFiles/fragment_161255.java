int vbo = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vbo);
glBufferData(GL_ARRAY_BUFFER, tightlyPackedData, GL_STATIC_DRAW);

int stride = (3 + 2 + 3) * Float.BYTES;

glVertexAttribPointer(positionIndex, 3, GL_FLOAT, false, stride, 0);
glVertexAttribPointer(texCoordIndex, 2, GL_FLOAT, false, stride, 3 * Float.BYTES);
glVertexAttribPointer(normalIndex,   3, GL_FLOAT, false, stride, (3 + 2) * Float.BYTES);