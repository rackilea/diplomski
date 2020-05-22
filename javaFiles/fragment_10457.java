double arr[][] = {{2, 3, 4, 6},
                {3, 6, 7.0, 3.3},
                {2.1, 3.4, 2, 7.7}
        };


        for(int j=0;j<arr[0].length;j++)
        {
            int row = 0;
            for (int i = 1; i < arr.length; i++) {
                row = (arr[row][j] < arr[i][j]) ? row : i;
            }
            System.out.println("Column = " + j + " Row = " + row);
        }