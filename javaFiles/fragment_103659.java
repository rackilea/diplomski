glBindVertexArray(vao);
 glEnableClientState( GL_VERTEX_ARRAY );   // <--------------
 glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);

 glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);

 glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
 glDisableClientState( GL_VERTEX_ARRAY ); // <---------------
 glBindVertexArray(0);