public class CalendarModel extends AbstractTableModel {

    public static String[] COLUMN_NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private int rows = 0;

    private LocalDate startOfCalendar;
    private LocalDate firstDayOfMonth;
    private LocalDate lastDayOfMonth;

    public CalendarModel(int year, Month month) {
        firstDayOfMonth = LocalDate.of(year, month, 1);

        startOfCalendar = firstDayOfMonth.minusDays(firstDayOfMonth.getDayOfWeek().getValue());
        lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(startOfCalendar.getDayOfWeek());
        System.out.println(firstDayOfMonth);
        System.out.println(lastDayOfMonth);

        Duration between = Duration.between(startOfCalendar.atStartOfDay(), lastDayOfMonth.atStartOfDay());
        long days = between.toDays();
        rows = (int) Math.round(days / 7d) + 1;
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return LocalDate.class;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        LocalDate date = null;

        if (startOfCalendar != null) {
            int day = (rowIndex * 7) + columnIndex;
            date = startOfCalendar.plusDays(day);

            if (date.isBefore(firstDayOfMonth) || date.isAfter(lastDayOfMonth)) {
                date = null;
            }
        }

        return date;

    }

}