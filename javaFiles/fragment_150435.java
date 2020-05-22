texture.bind();

glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
glVertexPointer(vertex_size, GL_FLOAT, 0, 0l);

glBindBuffer(GL_ARRAY_BUFFER, vbo_texture_handle);
glTexCoordPointer(texture_size, GL_FLOAT, 0, 0l);

glEnableClientState(GL_VERTEX_ARRAY);
glEnableClientState(GL_TEXTURE_COORD_ARRAY);

glDrawArrays(GL_TRIANGLES, 0, vertices); // The vertices is of course the max vertices count, in this case 6

glDisableClientState(GL_TEXTURE_COORD_ARRAY);
glDisableClientState(GL_VERTEX_ARRAY);

glBindBuffer(GL_ARRAY_BUFFER, 0);

texture.unbind();