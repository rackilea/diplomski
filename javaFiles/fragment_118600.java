int i = 0, j = 0;
for (final String token : tokens) {
    theGrid[i][j] = token;
    if (++j == 4) {
        j = 0;
        ++i;
    }
}