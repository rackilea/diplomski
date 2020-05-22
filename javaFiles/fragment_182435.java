for (int i = 0; i <= 6; i++) {
            for (int j = 5; j >= 0; j--) {
                if (myGrid[i][j] == 1) {
                    System.out.println("Counter one in diagonal check right is " + counter + ".");
                    if (myGrid[i + 1][j + 1] == 1 && (i + 1 <= 6) && (j + 1 <= 5)) counter++;
                    else if (myGrid[i - 1][j + 1] == 1 && (i - 1 >= 0) && (j + 1 <= 5)) counter++;
                }
            }
        }