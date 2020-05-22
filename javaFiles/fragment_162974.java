for (int i = 0; i < array.length; i++) {
        array[i] = new int[i + 1];
        for (int j = 0; j < i + 1; j++) {
            array[i][j] = i + j;
        }
    }