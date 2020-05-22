public class DateTableCellRenderer extends DefaultTableCellRenderer {
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof java.util.Date) {
            value = DATE_FORMAT.format(date);
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}