private void removeNoise() {
    int iterator;

    for (int row = 0; row < x1; row++) {
        for (int column = 0; column < y1; column++) {
            if (row == 0 || row == x1 - 1 || column == 0
                    || column == y1 - 1) {
                result[row][column] = result[row][column];
                continue;
            } else {
                iterator = 0;
                for (int r = row - 1; r < row + 2; r++) {
                    for (int c = column - 1; c < column + 2; c++) {
                        surround[iterator] = result[r][c];
                        iterator++;
                    }
                }
                result[row][column] =
                        sortMedian(surround, 9);  //calls the sorting method

            }

        }
    }
    setPixel();
}

private int sortMedian(int[] surround1, int x) {
    int i, j, t = 0;
    for (i = 0; i < 9; i++) {
        for (j = 1; j < (9 - i); j++) {
            if (surround1[j - 1] > surround1[j]) {
                t = surround1[j - 1];
                surround1[j - 1] = surround1[j];
                surround1[j] = t;
            }
        }
    }
    return surround1[4];
}

private void setPixel() {
    int[] pixel = new int[1];

    for (int x = 0; x < bi.getWidth(); x++) {
        for (int y = 0; y < bi.getHeight(); y++) {

            pixel[0] = (int) result[x][y];


              rnImage.getRaster().setPixel(x, y, pixel);

            }
        }
    }