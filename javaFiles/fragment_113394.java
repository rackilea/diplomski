@Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)
public class StreamTest {

    private static final UnaryOperator<double[][]> streamTranspose() {
        return m -> {
            return range(0, m[0].length).mapToObj(r ->
                range(0, m.length).mapToDouble(c -> m[c][r]).toArray()
            ).toArray(double[][]::new);
        };
    }

    private static final UnaryOperator<double[][]> parallelStreamTranspose() {
        return m -> {
            return range(0, m[0].length).parallel().mapToObj(r ->
                range(0, m.length).parallel().mapToDouble(c -> m[c][r]).toArray()
            ).toArray(double[][]::new);
        };
    }

    private static final Function<double[][], double[][]> forLoopTranspose() {
        return m -> {
            final int rows = m.length;
            final int columns = m[0].length;
            double[][] transpose = new double[columns][rows];
            for (int r = 0; r < rows; r++)
                  for (int c = 0; c < columns; c++)
                    transpose[c][r] = m[r][c];
            return transpose;
        };
    }

    @State(Scope.Benchmark)
    public static class MatrixContainer {

        @Param({ "100", "1000", "3000" })
        private int matrixSize;

        private double[][] matrix;

        @Setup(Level.Iteration)
        public void setUp() {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            matrix = random.doubles(matrixSize).mapToObj(i -> random.doubles(matrixSize).toArray()).toArray(double[][]::new);
        }

    }

    @Benchmark
    public double[][] streamTranspose(MatrixContainer c) {
        return streamTranspose().apply(c.matrix);
    }

    @Benchmark
    public double[][] parallelStreamTranspose(MatrixContainer c) {
        return parallelStreamTranspose().apply(c.matrix);
    }

    @Benchmark
    public double[][] forLoopTranspose(MatrixContainer c) {
        return forLoopTranspose().apply(c.matrix);
    }

}