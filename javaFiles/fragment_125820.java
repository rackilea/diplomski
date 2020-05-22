char[][] myArr = new char[size][size];
    for (int i = 0; i < size; ++i) {
        Arrays.fill(myArr[i], ' ');
    }
    // now we have square filled with spaces

    // draw diagonal, like you did it
    for (int c = 0; c < size; c++) {
        myArr[c][c] = 'X';
        myArr[c][size - c - 1] = 'X';
    }