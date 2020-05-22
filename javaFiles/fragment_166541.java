public class Mesh {
    public static long[] refineGrid(long[] cellsToProcess) {
        return Arrays.stream(cellsToProcess).parallel().flatMap(Mesh::expand).toArray();
    }
    static LongStream expand(long d) {
        return checkCell(d)? LongStream.of(d): generate(d).flatMap(Mesh::expand);
    }
    private static boolean checkCell(long cellId) {
        return cellId > 100;
    }
    private static LongStream generate(long cellId) {
        return LongStream.range(0, 8).map(j -> cellId * 10 + j);
    }
}