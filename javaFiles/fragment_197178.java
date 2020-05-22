for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int pixel = image.getRGB(x, y);
            byte alpha = (byte)((pixel >> 24) & 0xff);
            byte red = (byte)((pixel >> 16) & 0xff);
            byte green = (byte)((pixel >> 8) & 0xff);
            byte blue = (byte)((pixel >> 0) & 0xff);
            buffer.put(red);
            buffer.put(green);
            buffer.put(blue);
            buffer.put(alpha);
        }
    }