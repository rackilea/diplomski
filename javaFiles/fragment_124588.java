static class MyFunction extends Function<Row, String> {
    private String delimiter;
    private static final long serialVersionUID = 6766320395808127072L;

    MyFunction(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String call(Row row) throws Exception {
        return row.mkString(delimiter);
    }
}