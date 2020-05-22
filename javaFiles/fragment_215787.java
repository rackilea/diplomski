enum Month {
    JAN ("Jan", 31),
    FEB ("Feb", 28), 
    ....
    DEC ("Dec", 31);

    private final String monthName;
    private final int daysInMonth;

    private Month(String monthName, int daysInMonth) {
        this.monthName = monthName;
        this.daysInMonth = daysInMonth;
    }

    public String getName() {
        return monthName;
    }

    public static Month monthWithNumber(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) 
            throw new IllegalArgumentException();
        return values()[monthNumber - 1];
    }

    public isLegalDay(int day) {
        return day > 0 && day <= daysInMonth;
    }

    public isLastDayInMonth(int day) {
        return day == daysInMonth;
    }

    public Month nextMonth() {
        return values[(ordinal() + 1) % 12];
    }
}