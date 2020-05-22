gl.glTexCoord2d(0, 1);
  gl.glVertex2d(left, top);
  gl.glTexCoord2d(1, 1);
  gl.glVertex2d(left + width, top);
  gl.glTexCoord2d(1, 0);
  gl.glVertex2d(left + width, top + height);
  gl.glTexCoord2d(0, 0);
  gl.glVertex2d(left, top + height);