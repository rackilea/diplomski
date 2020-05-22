public static void main(final String a[]) {
    final MySchema s = new MySchema();
    final MyData<MySchema> d = new MyData<>();

    for (final Column<MySchema, ?> column : s.getColumns())
        encode(column, d);
}

private static <T> void encode(Column<T> column, MyData<MySchema> d) {
    System.out.println("encoded identifier: " + column.encode(d.get(column)));
}