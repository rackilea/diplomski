int[][] prob3 = new int[5][5];

    for (int row = 0; row < prob3.length; row++) {
        System.out.println();

        for (int col = prob3[row].length - 1; col >= 0; col--) {
            prob3[row][col] = row * 5 + col + 1;

            System.out.print(prob3[row][col] + " ");
        }
    }