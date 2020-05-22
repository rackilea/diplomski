public static void main(String... args) throws IOException {
    int w = 30, h = 30;

    // create the binary mapping
    byte BLACK = (byte)0, WHITE = (byte)255;
    byte[] map = {BLACK, WHITE};
    IndexColorModel icm = new IndexColorModel(1, map.length, map, map, map);

    // create checkered data
    int[] data = new int[w*h];
    for(int i=0; i<w; i++)
        for(int j=0; j<h; j++)
            data[i*h + j] = i%4<2 && j%4<2 || i%4>=2 && j%4>=2 ? BLACK:WHITE;

    // create image from color model and data
    WritableRaster raster = icm.createCompatibleWritableRaster(w, h);
    raster.setPixels(0, 0, w, h, data);
    BufferedImage bi = new BufferedImage(icm, raster, false, null);

    // output to a file
    ImageIO.write(bi, "jpg", new File("C:\\Users\\user\\Desktop\\test.jpg"));
}