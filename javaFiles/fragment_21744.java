TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

    SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if( value instanceof Time) {
            value = f.format(value);
        }
        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
    }
};
table.setDefaultRenderer(Time.class, tableCellRenderer);