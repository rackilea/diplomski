function generateTerrain() {
    int seed = rand.nextInt(colors.length);
    int sideLength = mapSize - 1;
    int halfSideLength;
    int average;
    int offset = 8;

    map[0][0] = seed;
    map[mapSize - 1][0] = seed;
    map[0][mapSize - 1] = seed;
    map[mapSize - 1][mapSize - 1] = seed;

    while (sideLength > 0) {
        halfSideLength /= 2;
        for (int x = 0; x < mapSize - 1; x += sideLength) {
            for (int y = 0; y < mapSize - 1; y += sideLength) {
                average = map[x][y]
                        + map[x + sideLength][y]
                        + map[x][y + sideLength]
                        + map[x + sideLength][y + sideLength];
                average /= 4;
                average += rand.nextInt(offset);

                map[x + halfSideLength][y + halfSideLength] = average;
            }
        }

        for (int x = 0; x < mapSize - 1; x += sideLength) {
            for (int y = 0; y < mapSize; y += sideLength) {
                int yTop = y - halfSideLength;
                int yBottom = y + halfSideLength;

                if (yTop < 0) yTop = y + halfSideLength;
                if (yBottom > mapSize - 1) yBottom = y - halfSideLength;

                average = map[x][y]
                        + map[x + sideLength][y]
                        + map[x + halfSideLength][yTop]
                        + map[x + halfSideLength][yBottom];
                average = /= 4;

                map[x + halfSideLength][y] = average;
            }
        }

        for (int x = 0; x < mapSize; x += sideLength) {
            for (int y = 0; y < mapSize - 1; y += sideLength) {
                int xLeft = x - halfSideLength;
                int xRight = x + halfSideLength;

                if (xLeft < 0) xLeft = x + halfSideLength;
                if (xRight > mapSize - 1) xRight = x - halfSideLength;

                average = map[x][y]
                        + map[x][y + sideLength]
                        + map[xRight][y + halfSideLength]
                        + map[xRight][y + halfSideLength];
                average /= 4;

                map[x][y + halfSideLength] = average;
            }
        }

        sideLength /= 2;
    }
}