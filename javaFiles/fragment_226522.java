int array[][] = { { 12, 43, 21, 87, 32 }, { 43, 75, 21, 45, 65 } };

    int t = 0;
    for (int x = 0; x < 2; x++) {
        for (int y = 0; y < 5; y++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    if (array[i][j] > array[x][y]) {
                        t = array[x][y];
                        array[x][y] = array[i][j];
                        array[i][j] = t;
                    }
                }
            }
        }
    }

    System.out.println("The Sorted Array:");
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.print(array[i][j] + "\t");
        }
        System.out.println();
    }