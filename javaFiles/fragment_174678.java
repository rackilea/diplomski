TextureCoords tc = texture.getImageTexCoords();
  gl.glTexCoord2f(tc.left(), tc.top());
  gl.glVertex2d(left, top);
  gl.glTexCoord2f(tc.right(), tc.top());
  gl.glVertex2d(left + width, top);
  gl.glTexCoord2f(tc.right(), tc.bottom());
  gl.glVertex2d(left + width, top + height);
  gl.glTexCoord2f(tc.left(), tc.bottom());
  gl.glVertex2d(left, top + height);