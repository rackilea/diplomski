// load the image from assests and then...
m_GLSurface.queueEvent(new Runnable() {
        public void run() {
                gl.glBindTexture(GL10.GL_TEXTURE_2D, m_TexId);

                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_CLAMP_TO_EDGE);
                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_CLAMP_TO_EDGE);
                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
                gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);

                if (gl instanceof GL11) {
                    // GL 1.1 has auto mip-map generation
                    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR_MIPMAP_LINEAR);
                    gl.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_GENERATE_MIPMAP, GL11.GL_TRUE);
                }

                GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, GL10.GL_RGBA, m_TexBitmap, 0);

                m_Semaphore.release();
            }
    });