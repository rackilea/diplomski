int[][] multi = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 5 }, { 7, 6 }, { 9, 8 } };

    Object[][] o = new Object[multi[0].length][multi.length];

    for (int i = 0; i < multi[0].length; i++) {
        for (int j = 0; j < multi.length; j++) {
            o[i][j] = multi[j][i];
        }
    }

    transpose(o);