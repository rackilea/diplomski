int[][] leftblock = new int[bitblock.length][bitblock[0].length / 2];
    int[][] rightblock = new int[bitblock.length][bitblock[0].length / 2];

    for (int i = 0; i < bitblock.length; i++) {
        for (int j = 0; j < bitblock[0].length / 2; j++) {
            leftblock[i][j] = bitblock[i][j];
        }

        for (int j = bitblock[0].length / 2; j < bitblock[0].length; j++) {
            rightblock[i][j - bitblock[0].length / 2] = bitblock[i][j];
        }
    }