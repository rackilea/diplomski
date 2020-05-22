// The lengths of each dimension of the values array
int l, m, n;
// Instead of:
// float[][][] values = new float[l][m][n];
// Do this:
float[] values = new float[l * m * n];

// To access an entry at (x, y, z) in the array.
// Instead of:
// float v = values[z][y][x];
// Do this:
int i = (m * n * z) + (n * y) + x;
float v = values[i];