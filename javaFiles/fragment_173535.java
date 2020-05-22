int counter = 0;
    for(int r = (n-1); r< n; r ++) {
        for(int c = (n/2); c<n; c++) {
            values[r][c] = list[counter];
            counter++;
        }
    }