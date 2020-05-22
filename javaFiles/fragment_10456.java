double arr[][] = {{2, 3, 4, 6},
                {3, 6, 7.0, 3.3},
                {2.1, 3.4, 2, 7.7}
        };

        for (int i = 0; i < arr.length; i++) {
        int column = 0;
        for (int j = 1; j < arr[i].length; j++) {
            column = (arr[i][column] < arr[i][j]) ? column : j;
        }
        System.out.println("Smallest element for row " + i + " = " + column +" th column");
    }