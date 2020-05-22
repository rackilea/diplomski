int vertexDataSize = vData.size() * 3;
int textureDataSize = tData.size() * 2;
[...]
glVertexAttribPointer(0, vertexDataSize, GL_FLOAT, false, 0, 0);
[...]
glVertexAttribPointer(1, textureDataSize, GL_FLOAT, false, 0, 0);