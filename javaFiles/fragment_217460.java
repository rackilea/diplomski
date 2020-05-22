DefaultTableModel model = new DefaultTableModel(...) {
    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 2: return ImageIcon.class;
            default: return String.class
        }
    }
};
JTable table = new JTable(model);