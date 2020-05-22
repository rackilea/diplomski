public static void main(String[] args) {
    // locale for determining weekends and start of week
    Locale locale = Locale.US;

    // we start by Sunday in first column of calendar (US-model)
    // and need one day only for displaying any calendar row (table view)
    Weekmodel weekmodel = Weekmodel.of(locale);
    Weekmodel rowmodel = Weekmodel.of(weekmodel.getFirstDayOfWeek(), 1);

    // our input configuration
    int year = 2016;
    Month month = Month.JANUARY;

    // determine limits of month
    PlainDate start = PlainDate.of(year, month, 1); // first day of month
    PlainDate end = start.with(PlainDate.DAY_OF_MONTH.maximized()); // last day of month

    // we choose bounded-week because we need a monotonously increasing number
    int rowMin = start.get(rowmodel.boundedWeekOfMonth());
    int rowMax = end.get(rowmodel.boundedWeekOfMonth());

    // table creation
    Object[][] table = new Object[rowMax - rowMin + 1][7];

    // iterate over the month day by day
    PlainDate date = start;
    int column; // zero-based
    int row; // zero-based

    do {
        column = date.getDayOfWeek().getValue(weekmodel) - 1;
        row = date.get(rowmodel.boundedWeekOfMonth()) - rowMin;
        table[row][column] = new Cell(date.getDayOfMonth(), date.isWeekend(locale));
        date = date.plus(1, CalendarUnit.DAYS);
    } while (!date.isAfter(end));

    // HTML output (example)
    System.out.println("<table border=\"1\">");
    System.out.println("<caption>" + month.getDisplayName(locale) + " " + year + "</caption>");

    for (int i = 0; i < table.length; i++) {
        System.out.print("<tr>\n\t");
        for (int j = 0; j < 7; j++) {
            Cell cell = (Cell) table[i][j];
            System.out.print("<td>");
            if (cell != null) {
                if (cell.weekend) {
                    System.out.print("<strong>");
                }
                System.out.print(cell.dayOfMonth);
                if (cell.weekend) {
                    System.out.print("</strong>");
                }
            }
            System.out.print("</td>");
        }
        System.out.print("\n</tr>\n");
    }
    System.out.println("\n</table>");
}

static class Cell {
    final int dayOfMonth;
    final boolean weekend;

    Cell(int dayOfMonth, boolean weekend) {
        this.dayOfMonth = dayOfMonth;
        this.weekend = weekend;
    }
}