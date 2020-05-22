private CPTable(JTable table) {
    super(table);
    this.table = table;
}

public CPTable(Object[] headers, Object[][] data) {
    this(new JTable(data, headers));
}