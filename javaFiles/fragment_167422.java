private class CurrencyCellRenderer extends DefaultTableCellRenderer {

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            value = 0.0;
        } 
        value = myFormat.format(value);

        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);

        return result;
    }
}