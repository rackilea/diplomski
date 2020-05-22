// special case: sourceWidth and sourceHeight are powers of 2
int wMask = sourceWidth - 1, hMask = sourceHeight - 1;
for(int i = 0, k = 0; i < width; ++i, ++k) {
    for(int j = 0, l = 0; j < height; ++j, ++l) {
        set(i, j, pixel(i & wMask, j & hMask));
    }
}