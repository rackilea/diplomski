public static UnaryOperator<double[][]> transpose() {
    return m -> {
        return range(0, m[0].length).mapToObj(r ->
            range(0, m.length).mapToDouble(c -> m[c][r]).toArray()
        ).toArray(double[][]::new);
    };
}