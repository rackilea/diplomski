public static final ColumnConstraints[] createColumns(int count) {
    ColumnConstraints[] columns = new ColumnConstraints[count];

    for(int i = 0; i < count; i++) {
        ColumnConstraints column = new ColumnConstraints(1, 10, Double.MAX_VALUE);
        column.setPercentWidth(100/count); // do we still need this?
        column.setFillWidth(true);
        column.setHgrow(Priority.ALWAYS);
        column.setHalignment(HPos.CENTER);
        columns[i] = column;
    }

    return columns;
}