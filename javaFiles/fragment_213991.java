public class LocalDateTableCellRenderer extends DefaultTableCellRenderer {

    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
    private String[][] bookings;

    public LocalDateTableCellRenderer(String[][] bookings) {
        this.bookings = bookings;
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
        if (value instanceof LocalDate) {
            LocalDate date = (LocalDate) value;
            if (hasBookingFor(date)) {
                setForeground(Color.WHITE);
                setBackground(Color.RED);
            }
            setText(formatter.format(date));
        } else {
            setText(null);
        }
        return this;
    }

    protected boolean hasBookingFor(LocalDate date) {
        for (String[] data : bookings) {
            int day = Integer.parseInt(data[2]);
            int month = Integer.parseInt(data[3]);
            int year = 2017; // Because :P

            LocalDate booking = LocalDate.of(year, month, day);
            if (booking.isEqual(date)) {
                return true;
            }
        }
        return false;
    }

}