for(int i = 0, k = 0; i < width; ++i, ++k) {
    if(k == sourceWidth) { k = 0; }
    for(int j = 0, l = 0; j < height; ++j, ++l) {
        if(l == sourceHeight) { l = 0; }
        set(i, j, pixel(k, l));
    }
}