for (int j = 0; j < lines - 1; j++) {  //sorts the array by slopes
        if (lineMXYC[0][j] > lineMXYC[0][j + 1]) {
            for (int i = 0; i < 4; i++) {
                double TEMP = lineMXYC[i][j + 1];
                lineMXYC[i][j + 1] = lineMXYC[i][j];
                lineMXYC[i][j] = TEMP;
            }
        }
    }