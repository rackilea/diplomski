for(i = 0, j = 0; i < n; i++, j++) //fill elements in row 0
        a[0][i] = bounds[j];
    for(i = 1; i < m - 1; i++, j++) //fill elements in column (n-1) from row 1 to m-2
        a[i][n - 1] = bounds[j];
    for(i = n - 1; i >= 0; i--, j++) //fill row m-1, columns n-2 to 1
        a[m - 1][i] = bounds[j];
    for(i = m - 2; i >= 1; i--, j++) //row m-2 to 1, column 0
        a[i][0] = bounds[j];