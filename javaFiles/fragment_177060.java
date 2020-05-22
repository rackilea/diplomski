table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == table.getSelectedColumn()) {
            c.setBackground(new Color (57, 105, 138));
            c.setForeground(Color.white);
        } else if (row == table.getSelectedRow()) {
            c.setBackground(new Color (57, 105, 138));
            c.setForeground(Color.white);
        } else {
            if (row % 2 == 0) {
                c.setBackground(Color.white);
                c.setForeground(Color.black);
            } else {
                c.setBackground(new Color(242, 242, 242));
                c.setForeground(Color.black);
            }
        }

        return c;
    }
});