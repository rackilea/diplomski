GLushort indices[] = {0,1,3};
glDrawElements(
  GL_TRIANGLES /* what */,
  3 /* how many */,
  GL_UNSIGNED_SHORT /* type of index elements */,
  indices );