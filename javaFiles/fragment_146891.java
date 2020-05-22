public boolean isHoliday(long date) {
    return holidaysCalendar.isHoliday(new LocalDate(date));
}

public boolean isSaturday(long date) {
    return (new LocalDate(date).dayOfWeek().get() == 7);
}

public boolean isSunday(long date) {
    return (new LocalDate(date).dayOfWeek().get() == 1);
}

public boolean isValid(long date, boolean saturday, boolean sunday) {
    boolean valid = true;
    if (isHoliday(date)) {
        valid = false;
    } else {
        if (!saturday && isSaturday(date)) {
            valid = false;
        }
        if (!sunday && isSunday(date)) {
            valid = false;
        }
    }
    return valid;
}

public long addDays(long date, int days) {
    return new LocalDate(date).plusDays(days).toDateTimeAtStartOfDay()
            .getMillis();
}

public int validDaysBetweenDates(long date1, long date2,
        boolean saturday, boolean sunday) {
    date1 = addDias(date1, 1);
    int cont = 0;
    for (long dateTmp = date1; dataTmp <= date2; dataTmp = addDays(dataTmp, 1)) {
        if (isValid(dataTmp, saturday, sunday))
            cont++;
    }
    return cont;
}