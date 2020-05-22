Image img = new Image("file:test.png");
int width = (int) img.getWidth();
int height = (int) img.getHeight();
PixelReader reader = img.getPixelReader();
byte[] buffer = new byte[width * height * 4];
WritablePixelFormat<ByteBuffer> format = PixelFormat.getByteBgraInstance();
reader.getPixels(0, 0, width, height, format, buffer, 0, width * 4);
try {
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("test.data"));
    for(int count = 0; count < buffer.length; count += 4) {
        out.write(buffer[count + 2]);
        out.write(buffer[count + 1]);
        out.write(buffer[count]);
        out.write(buffer[count + 3]);
    }
    out.flush();
    out.close();
} catch(IOException e) {
    e.printStackTrace();
}