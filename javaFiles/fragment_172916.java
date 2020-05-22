int l = intArray.length;
    int[][] newArray = new int[l][l];

    for (int i = 0; i < l; i++) {
        for (int j = 0; j < l; j++) {
            newArray[i][j] = j == i ? intArray[j] * -1 : intArray[j];
        }
    }