int[][] multiDimensional = null;

int rows = ... ;// Determine number of rows
multiDimensional = new int[rows][];

for(final int[] row: multiDimensional) {
    final int cols = ...; // Determine number of cols for this row
    row = new int[cols];
}