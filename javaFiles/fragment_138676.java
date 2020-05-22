int[] rgbArray = new int[WIDTH * HEIGHT];
for(int y = 0; y < HEIGHT; ++y) {
    for(int x = 0; x < WIDTH; ++x) {
        int r = (int)(imageData.get() * 255) << 16;
        int g = (int)(imageData.get() * 255) << 8;
        int b = (int)(imageData.get() * 255);
        int i = ((HEIGHT - 1) - y) * WIDTH + x;
        rgbArray[i] = r + g + b;
    }
}