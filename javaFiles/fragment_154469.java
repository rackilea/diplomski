public void foo() {
    for (int i = 0; i < rows; i++)
        for(j = 0; j < columns; j++)
            table[i][j] = new Blabla(i, j);
            count++;                // <--- potential bug!
    other();
}