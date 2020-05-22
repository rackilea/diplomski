public static double[] multiply(double[][] matrix, double[] vector) {
    return Arrays.stream(matrix)
                 .mapToDouble(row -> 
                    IntStream.range(0, row.length)
                             .mapToDouble(col -> row[col] * vector[col])
                             .sum()
                 ).toArray();
}