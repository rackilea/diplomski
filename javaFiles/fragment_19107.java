private final Map<TableColumn<T,?>, Class<?>> columnTypes = new HashMap<>();

public <S> void addColumn(TableColumn<T,S> col, Class<S> type) {
    getColumns().add(col) ;
    columnTypes.put(col, type);
}