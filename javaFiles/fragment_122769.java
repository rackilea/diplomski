for(int i=0, k=0; i<9; i++) {
    // generate vertical regions
    for(int j=0; j<9; j++)
        table[k][j] = new table_t(i, j);
    k++;
    // generate horizontal regions
    for(int j=0; j<9; j++)
        table[k][j] = new table_t(j, i);
    k++;
    // generate 3x3 regions
    for(int j=0; j<9; j++)
        table[k][j] = new table_t((i/3)*3+j/3, (i%3)*3+j%3);
    k++;
}