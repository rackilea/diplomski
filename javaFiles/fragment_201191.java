PixelReader pixelReader = img.getPixelReader();
int width = (int)img.getWidth();
int height = (int)img.getHeight();
byte[] buffer = new byte[width * height * 4];
pixelReader.getPixels(
        0,
        0,
        width,
        height,
        PixelFormat.getByteBgraInstance(),
        buffer,
        0,
        width * 4
);