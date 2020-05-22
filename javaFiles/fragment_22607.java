DefaultTableModel model = new DefaultTableModel() {
    @Override
    public void setValueAt(Object value,
            int rowIndex,
            int columnIndex) {
        super.setValueAt(value, rowIndex, columnIndex);
        ProductsT.setRowSelectionInterval(rowIndex, rowIndex);
        ProductsT.changeSelection(rowIndex, columnIndex + 1, false, false);
    }
};