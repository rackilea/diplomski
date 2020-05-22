@SuppressWarnings("serial")
class IntegerCellRenderer2 extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        String resultString = String.format("~%d~", (Integer) value);
        setText(resultString);
        setHorizontalAlignment(JLabel.CENTER);
        return super.getTableCellRendererComponent(table, resultString, isSelected, hasFocus, row, column);
    }
}