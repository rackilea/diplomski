protected void saveImage(GL4 gl4, int width, int height) {

        try {

            GL4 gl4 = GLContext.getCurrentGL().getGL4();

            BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = screenshot.getGraphics();

            ByteBuffer buffer = GLBuffers.newDirectByteBuffer(width * height * 4);

            gl4.glReadBuffer(GL_BACK);
            gl4.glReadPixels(0, 0, width, height, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    graphics.setColor(new Color((buffer.get() & 0xff), (buffer.get() & 0xff),
                            (buffer.get() & 0xff)));
                    buffer.get();   
                    graphics.drawRect(w, height - h, 1, 1);
                }
            }
            BufferUtils.destroyDirectBuffer(buffer);
            File outputfile = new File("D:\\Downloads\\texture.png");
            ImageIO.write(screenshot, "png", outputfile);
        } catch (IOException ex) {
              Logger.getLogger(EC_DepthPeeling.class.getName()).log(Level.SEVERE, null, ex);
        }
    }