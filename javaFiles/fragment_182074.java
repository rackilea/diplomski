public static <X, Y, Z, S extends Collection<Z>> void addCellValue(
    Table<X, Y, S> table, X rowKey, Y colKey, Z value, Supplier<S> supplier) {

    final S data;
    if (table.contains(rowKey, colKey)) {
        data = table.get(rowKey, colKey);
    } else {
        data = supplier.get();
        table.put(rowKey, colKey, data);
    }
    data.add(value);

}