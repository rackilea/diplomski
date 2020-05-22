int rows = matrix.lenght;
int cols = matix[0].lenght;

List<List<Integer>>orderedSavingsList = IntStream.range(0, rows).mapToObj(i ->
            IntStream.range(0, cols).mapToObj(j ->
                    new double[]{i, j, matrix[i][j]}
            )
    )
    .flatMap(x -> x).filter(t -> t[0] < t[1])
    .sorted((a, b) -> Double.compare(b[2], a[2]))
    .map(a -> Arrays.asList((int) a[0], (int) a[1]))
    .collect(Collectors.toList());