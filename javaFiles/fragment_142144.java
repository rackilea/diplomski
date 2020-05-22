JavaRDD<MatrixEntry> entries = ata.toCoordinateMatrix().entries().toJavaRDD();
JavaRDD<String> output = entries.map(new Function<MatrixEntry, String>() {
    public String call(MatrixEntry e) {
        return String.format("%d,%d,%s", e.i(), e.j(), e.value());
    }
});
output.saveAsTextFile("data/output1");