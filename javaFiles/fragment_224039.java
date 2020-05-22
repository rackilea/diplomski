private Point[] prepareData() {
    Point[] pixels = new Point[width*height];
    int idx = 0;
    for (int y = 0; y < height; y++)
        for (int x = 0; x < width; x++)
            pixels[idx++] = new Point(x, y);
    return pixels;
}