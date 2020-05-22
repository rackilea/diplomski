private static Set<String> dates = new HashSet<String>();
static {
    for (int year = 1900; year < 2050; year++) {
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= daysInMonth(year, month); day++) {
                StringBuilder date = new StringBuilder();
                date.append(String.format("%04d", year));
                date.append(String.format("%02d", month));
                date.append(String.format("%02d", day));
                dates.add(date.toString());
            }
        }
    }
}

public static boolean isValidDate2(String dateString) {
    return dates.contains(dateString);
}