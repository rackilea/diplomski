private static synchronized byte[] grabScreen()
{
    int w = screenWidth;
    int h = screenHeight;
    ByteBuffer bufor = BufferUtils.createByteBuffer(w * h * 3);

    GL11.glReadPixels(0, 0, w, h, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, bufor); //Copy the image to the array imageData

    byte[] byteimg = new byte[w * h * 3];
    bufor.get(byteimg, 0, byteimg.length);
    return byteimg;
}