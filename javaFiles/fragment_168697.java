glBindVertexArray(vaoId);
glEnableClientState( GL_VERTEX_ARRAY ); // <---------------

glDrawArrays(GL_TRIANGLES, 0, vertexCount);

glDisableClientState( GL_VERTEX_ARRAY ); // <---------------
glBindVertexArray(0);