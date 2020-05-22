table.setDefaultRenderer(Date.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof Date) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM-yyyy");
            value = formatter.format((Date)value);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
});