public static class MyData<S extends Schema<S>> {
    public <T> T get(final Column<S, T> column) {...}

    public <T> String getEncoded(final Column<S, T> column) {
         return column.encode(get(column));
    }
}