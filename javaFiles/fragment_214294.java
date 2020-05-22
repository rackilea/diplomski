final String[] names = { "Type", "Company", "Shares", "Price" };
final Object[][] products = {
        { "Buy", "IBM", new Integer(1000), new Double(80.50) },
        { "Sell", "MicroSoft", new Integer(2000), new Double(6.25) },
        { "Sell", "Apple", new Integer(3000), new Double(7.35) },
        { "Buy", "Nortel", new Integer(4000), new Double(20.00) } };

JTable table = new JTable(new AbstractTableModel() {

    @Override
    public String getColumnName(int col) {
        return names[col];
    }

    @Override
    public int getRowCount() {
        return products.length;
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return products[row][col];
    }

});

JScrollPane scrollPane = new JScrollPane(table);
// now add the scroll pane in `JPanel`