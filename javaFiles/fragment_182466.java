public Date calculateLastDayOfLastQuarter(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    int year = calendar.get(Calendar.YEAR);

    try {
        switch (calendar.get(Calendar.MONTH)) {
        case Calendar.JANUARY:
        case Calendar.FEBRUARY:
        case Calendar.MARCH:
            return sdf.parse("31.12." + (year - 1));
        case Calendar.APRIL:
        case Calendar.MAY:
        case Calendar.JUNE:
            return sdf.parse("31.03." + year);
        case Calendar.JULY:
        case Calendar.AUGUST:
        case Calendar.SEPTEMBER:
            return sdf.parse("30.06." + year);
        case Calendar.OCTOBER:
        case Calendar.NOVEMBER:
        case Calendar.DECEMBER:
            return sdf.parse("30.09." + year);
        default:
            return null;
        }
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
    }
}