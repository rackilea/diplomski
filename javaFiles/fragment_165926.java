protected void saveImage(GL3 gl3, int width, int height) {

    try {
        BufferedImage screenshot = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = screenshot.getGraphics();

        ByteBuffer buffer = GLBuffers.newDirectByteBuffer(width * height * 4);
        // be sure you are reading from the right fbo (here is supposed to be the default one)
        // bind the right buffer to read from
        gl3.glReadBuffer(GL_BACK);
        // if the width is not multiple of 4, set unpackPixel = 1
        gl3.glReadPixels(0, 0, width, height, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                // The color are the three consecutive bytes, it's like referencing
                // to the next consecutive array elements, so we got red, green, blue..
                // red, green, blue, and so on..+ ", "
                graphics.setColor(new Color((buffer.get() & 0xff), (buffer.get() & 0xff),
                        (buffer.get() & 0xff)));
                buffer.get();   // consume alpha
                graphics.drawRect(w, height - h, 1, 1); // height - h is for flipping the image
            }
        }
        // This is one util of mine, it make sure you clean the direct buffer
        BufferUtils.destroyDirectBuffer(buffer);

        File outputfile = new File("D:\\Downloads\\texture.png");
        ImageIO.write(screenshot, "png", outputfile);
    } catch (IOException ex) {
    }
}