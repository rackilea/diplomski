int[][] matrix = new int[5][4];
    boolean columnEmpty = true;
    int column = 0;
    boolean key = false;

    matrix[0][0] = -1;
    matrix[0][1] = -1;
    matrix[1][1] = 1;
    matrix[1][2] = -1;
    matrix[2][2] = -1;

    outerloop: for (int i = 0; i < 5; i++){
            columnEmpty = true;
            for (int j = 0; j < 4; j++){
                if (matrix[j][i] != 0) {
                   columnEmpty = false;
                   break;
                }

            }
            if (columnEmpty) {
                // If we are here.. then flag was never set to `true`. 
                // So, all the rows for that column was Zero..
                column = i; 
                key = true;
                break outerloop;
            }

        }

    System.out.println("Column : " + column);