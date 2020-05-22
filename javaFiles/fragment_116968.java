glBindTexture(GL_TEXTURE_2D, texture.getTextureID());
// vertices
glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);
// texCoords
glBindBuffer(GL_ARRAY_BUFFER, vboTexCoordHandle);
glBufferData(GL_ARRAY_BUFFER, textureData, GL_STATIC_DRAW);
glTexCoordPointer(3, GL_FLOAT, 0, 0);
// unbind VBO
glBindBuffer(GL_ARRAY_BUFFER, 0);

glEnableClientState(GL_VERTEX_ARRAY);
glEnableClientState(GL_TEXTURE_COORD_ARRAY);

glDrawArrays(GL_QUADS, 0, amountOfVertices);

glDisableClientState(GL_COLOR_ARRAY);
glDisableClientState(GL_TEXTURE_COORD_ARRAY);