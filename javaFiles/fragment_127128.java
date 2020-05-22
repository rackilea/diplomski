DefaultTableModel dtm = new DefaultTableModel() {

    @Override
    public Class<?> getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
};
// add some data
JTable table = new JTable(dtm);