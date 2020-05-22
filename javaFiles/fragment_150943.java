gl.glBindTexture(GL2.GL_TEXTURE_2D, textureID[0]);
/*... */
gl.glGenFramebuffers(1, frameBufferID, 0);
gl.glBindFramebuffer(GL2.GL_FRAMEBUFFER, frameBufferID[0]);

//Attach 2D texture to this FBO
gl.glFramebufferTexture2D(GL2.GL_FRAMEBUFFER, GL2.GL_COLOR_ATTACHMENT0, 
                                GL2.GL_TEXTURE_2D, textureID[0], 0);