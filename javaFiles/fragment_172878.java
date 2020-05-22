int[] scalar = ... // convert from Scalar object

// assuming the result of get() is an int[], sum both arrays:
int[] data = your_mat.get(row, col) + scalar // <- pseudo-code alert :D

your_mat.put(row, col, data);