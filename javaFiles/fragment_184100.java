int iLow, lowest = Integer.MAX_VALUE;

for (int i = 0; i < 9; ++i) {
    if (runningSumPixel[i] < lowest) {
        iLow = i;
        lowest = runningSumPixel[i];
}

newImageTRGB[ColComp][column][row] = pixelNeighbors[iLow];