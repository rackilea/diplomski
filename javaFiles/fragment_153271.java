glBindVertexArray(vaoID);
glEnableVertexAttribArray(indexLocation);

glBindBuffer(GL_ARRAY_BUFFER, vboID);
glVertexAttribPointer(indexLocation, 2, GL_FLOAT, false, 0, 0);

glBindBuffer(GL_ARRAY_BUFFER, 0);
glBindVertexArray(0);