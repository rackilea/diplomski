new AbstractTableModel() {
    public int getColumnCount() {
        return 0;
    }

    public int getRowCount() {
        return 0;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public boolean isCellEditable(int row, int col) {
        if (col == 4) {
            return true;
        } else {
            return false;
        }
    }
};