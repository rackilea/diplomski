final JTable table = new JTable(tableModel);
table.setColumnSelectionAllowed(true);
table.getTableHeader().addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Get the right column based on MouseEvent#getPoint()
        int columnIndex = table.columnAtPoint(e.getPoint());
        // Set this column as the selected one in the columns selection model
        table.getColumnModel().getSelectionModel().setSelectionInterval(columnIndex, columnIndex);
        // Set all the rows as the selected ones in the rows selection model
        table.getSelectionModel().setSelectionInterval(0, table.getRowCount() - 1);
        // Print the values in selected column
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            System.out.println(table.getValueAt(rowIndex, columnIndex));
        }
    }
});