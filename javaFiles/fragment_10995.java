int w = 640;
int h = 480;
BufferedImage i = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
for (int y=0; y<h; ++y) {
    for (int x=0; x<w; ++x) {
        // calculate index of pixel
        // depends on exact organization of image
        // sample assumes linear storage with r, g, b pixel order
        int index = (y * w * 3) + (x * 3);
        // combine to RGB format
        int rgb = ((data[index++] & 0xFF) << 16) |
                  ((data[index++] & 0xFF) <<  8) |
                  ((data[index++] & 0xFF)      ) |
                  0xFF000000;
        i.setRGB(x, y, rgb);
    }
}