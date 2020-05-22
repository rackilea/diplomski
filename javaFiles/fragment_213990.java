private static Color BOOKED_COLOR = Color.RED;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Room && value != null) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
                setForeground(table.getSelectionForeground());
            } else {
                setBackground(table.getBackground());
                setForeground(table.getForeground());
            }
            // Update the details based on the room properties
        } else { //if (value == null) {
            setBackground(BOOKED_COLOR);
            setText(null);
        }
        return this;
    }

}