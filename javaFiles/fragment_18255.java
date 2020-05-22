public MyTableInTreeCellRenderer() {
    super();
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    table = new JTable();
    add(table.getTableHeader());
    add(table);
}