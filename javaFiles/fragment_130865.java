public static String toString(double[][] M) {
    String separator = ", ";
    StringBuffer result = new StringBuffer();

    // iterate over the first dimension
    for (int i = 0; i < M.length; i++) {
        // iterate over the second dimension
        for(int j = 0; j < M[i].length; j++){
            result.append(M[i][j]);
            result.append(separator);
        }
        // remove the last separator
        result.setLength(result.length() - separator.length());
        // add a line break.
        result.append("\n");
    }
    return result.toString();
}