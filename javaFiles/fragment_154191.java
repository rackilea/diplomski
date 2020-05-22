for (int r = 0; r < rows; r++) {

        for (int c = 0; c < cols; c++) { // instead of cols++
            matrix[r][c] = (int) (Math.random() * (rows * cols));
        }
    }