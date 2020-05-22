Object[][] returnValue = transpose(o);
    int[][] multiTransposed = new int[returnValue[0].length][returnValue.length];

    for (int i = 0; i < returnValue[0].length; i++) {
        for (int j = 0; j < returnValue.length; j++) {
            multiTransposed[i][j] = (int)returnValue[j][i];
        }
    }