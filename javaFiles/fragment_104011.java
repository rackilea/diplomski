int width = (int)image.getWidth();
    int height = (int)image.getHeight();

    int[] pixels = new int[width * height];
    WritablePixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbPreInstance();
    pr.getPixels(0, 0, width, height, pixelFormat, pixels, 0, width);

    int[] newPixels = new int[pixels.length];
    for (int i = 0 ; i < pixels.length; i++) {
        int c = pixels[i];
        int a = c & 0xFF000000 ;
        int r = (c >> 16) & 0xFF ;
        int g = (c >> 8) & 0xFF ;
        int b = c & 0xFF ;
        int gray = (r+g+b) / 3 ;
        newPixels[i] = a | (gray << 16) | (gray << 8) | gray ;
    }

    pw.setPixels(0, 0, width, height, pixelFormat, newPixels, 0, width);