glEnableClientState(GL_VERTEX_ARRAY);
glEnableClientState(GL_TEXTURE_COORD_ARRAY);

glVertexPointer(
  2 /* = number of elements per attribute */,
  GL_FLOAT /* type of attribute elements */,
  0 /* = the byte distance between attributes OR zero if tightly packed */,
  quad_pos_a );
glTexCoordPointer(
  2 /* = number of elements per attribute */,
  GL_FLOAT /* type of attribute elements */,
  0 /* = the byte distance between attributes OR zero if tightly packed */,
  quad_texc );

glDrawArrays(
  GL_QUADS /* what to draw */,
  0 /* which index to start with */,
  4 /* how many vertices to process*/ );