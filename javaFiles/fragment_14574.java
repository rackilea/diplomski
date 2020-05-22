for(i = 0; i < matrix.length; i++) {
        l = matrix[0].length - 1; // <--- This line
        for(j = 0; j < matrix[i].length; j++)
            rr[k][l--] = matrix[i][j]; 
        k--;
    }