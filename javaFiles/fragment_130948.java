class CurrencyRenderer extends DefaultTableCellRenderer {

    private final NumberFormat currencyFormat;

    public CurrencyRenderer() {
        currencyFormat = NumberFormat.getCurrencyInstance();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setText(currencyFormat.format((Number)value));
        }
        return renderer;
    }
}