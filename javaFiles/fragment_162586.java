model = new DefaultTableModel(data, columnNames) {

    private static final long serialVersionUID = 1L;

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
table = new JTable(model);