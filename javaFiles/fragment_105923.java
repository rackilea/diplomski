int[] manualPixels = new int[width * height];
for (int index = 0; index < manualPixels.length; index++) {
    switch (index % 3) {
        case 0: manualPixels[index] = 0xFF0000; break; // red
        case 1: manualPixels[index] = 0x00FF00; break; // green
        case 2: manualPixels[index] = 0x0000FF; break; // blue
    }
}