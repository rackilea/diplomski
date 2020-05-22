int[] tableSizes = new int[9];
tableSizes[0] = 9;
tableSizes[1] = 9;
tableSizes[2] = 8;
// and so on
int[][] tables = new int[9][]; // create the 'outer' array
for (int i = 0; i < 9; i++) {
    tables[i] = new int[tableSizes[i]]; // create the 'inner' arrays
}
// access like this
int var = tables[0][1]; // second value of first table
tables[1][0] = 1; // first value of second table