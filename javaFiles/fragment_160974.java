private static final Random RAND = new Random(new Date().getTime());
private static final int ROW_UPPER_BOUND = 10;
private static final int COL_UPPER_BOUND = 8;

/**
 * @param args
 */
public static void main(String[] args) {
    float[][] matrix;
    int rows = anyRows();
    // Create array of null "pointers".
    matrix = new float[rows][];
    for (int row = 0; row < rows; ++row) {
        // Assign array "pointers" to first dimension of matrix.
        matrix[row] = anyArrayOfFloats();
    }
    System.out.println(matrixToString(matrix));
}

public static int anyRows() {
    return RAND.nextInt(ROW_UPPER_BOUND) + 1;
}

public static float anyFloat() {
    return RAND.nextFloat();
}

public static float[] anyArrayOfFloats() {
    int sz = RAND.nextInt(COL_UPPER_BOUND) + 1;
    float[] arr = new float[sz];
    for (int i = 0; i < sz; ++i) arr[i] = anyFloat();
    return arr;
}

public static String matrixToString(float[][] matrix) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    boolean first = true;
    for (float[] fArr: matrix) {
        if (first) {first = false;} else {builder.append(", ");}
        builder.append(Arrays.toString(fArr));
    }
    builder.append("]");
    return builder.toString();
}