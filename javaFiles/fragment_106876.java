DefaultTableModel m = new DefaultTableModel() {
    @Override
    public Class<?> getColumnClass(int column) {
        if (column == 1) {
            return Integer.class;
        }
        return super.getColumnClass(column);
    }
};