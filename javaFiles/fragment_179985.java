public static Image crop(Image src, int col, int row) {
    PixelReader r = src.getPixelReader();
    PixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbInstance() ;
    int[] pixels = new int[Grid.SIZE * Grid.SIZE];
    r.getPixels(col * Grid.SIZE, row * Grid.SIZE, Grid.SIZE, Grid.SIZE, pixelFormat,
        pixels, 0, Grid.SIZE);
    WritableImage out = new WritableImage(Grid.SIZE, Grid.SIZE);
    PixelWriter w = out.getPixelWriter();
    w.setPixels(0, 0, Grid.SIZE, Grid.SIZE, pixelFormat,
        pixels, 0, Grid.SIZE);
    return out ;
}