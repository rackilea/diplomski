for (int row = 0; row < multTable.length; row++) {
        for (int column = 0; column < multTable[row].length; column++) {
            multTable[row][column] = (row + 1) * (column + 1);
            System.out.printf("%3d", multTable[row][column]);
        }
        System.out.println();
    }