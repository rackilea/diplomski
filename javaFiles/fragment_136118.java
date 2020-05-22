@Warmup(iterations = 10, time = 700, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 700, timeUnit = TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(5)
public class StreamTest {

    @State(Scope.Benchmark)
    public static class LengthContainer {

        @Param({ "100", "1000", "3000" })
        private int length;

    }

    private static double[][] toArrayStream(int rowDimension, int columnDimension) {
        return IntStream.range(0, Math.min(rowDimension, columnDimension)).mapToObj(r -> {
            double[] row = new double[columnDimension];
            row[r] = 1;
            return row;
        }).toArray(double[][]::new);
    }

    private static double[][] toArrayStreamForEach(int row, int column) {
        double[][] identity = new double[row][column];
        IntStream.range(0, row).forEach(i -> identity[i][i] = 1);
        return identity;
    }

    private static double[][] toArrayForLoop(int row, int column) {
        double[][] matrix = new double[row][column];
        for (int i = 0; i < Math.min(row, column); i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    @Benchmark
    public double[][] toArrayStream(LengthContainer container) {
        return toArrayStream(container.length, container.length);
    }

    @Benchmark
    public double[][] toArrayForLoop(LengthContainer container) {
        return toArrayForLoop(container.length, container.length);
    }

    @Benchmark
    public double[][] toArrayStreamForEach(LengthContainer container) {
        return toArrayStreamForEach(container.length, container.length);
    }

}