glEnableVertexAttribArray(0);
glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * 4 + 2, 0);
glEnableVertexAttribArray(1);
glVertexAttribIPointer(1, 1, GL_UNSIGNED_BYTE, 3 * 4 + 2, 3 * 4);
glEnableVertexAttribArray(2);
glVertexAttribIPointer(2, 1, GL_UNSIGNED_BYTE, 3 * 4 + 2, 3 * 4 + 1);