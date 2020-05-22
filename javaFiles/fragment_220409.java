IntBuffer ib = IntBuffer.allocate(1);  //Store this in your object
gl.glGenTextures(1, ib);
gl.glPixelStorei(GL.GL_PACK_ALIGNMENT, 1);
//buff contains pixels read from glReadPixels
gl.glBindTexture(GL.GL_TEXTURE_2D, ib.get(0));
gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, width, height, 0, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, 0);
gl.glBindTexture(GL.GL_TEXTURE_2D, 0);