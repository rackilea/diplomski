for(int i = 0; i < width; ++i) {
    int k = i % sourceWidth;
    for(int j = 0; j < height; ++j) {
        int l = j % sourceHeight;
        set(i, j, pixel(k, l));
    }
}