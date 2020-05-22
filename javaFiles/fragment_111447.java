public static long getDaysDif(LocalDate fromDate, LocalDate toDate) {
    return ChronoUnit.DAYS.between(fromDate, toDate);
}

public static LocalDate getLocalDateFromString(String d, String format) {
    return LocalDate.parse(d, DateTimeFormatter.ofPattern(format));
}

public static void main(String[] args) {
    List<String> list = new ArrayList<>
            (Arrays.asList
                    ("2018-09-05", "2018-09-13", "2018-09-14", "2018-09-28", "2018-09-29", "2018-10-13"));
    for (int i = 0; i < list.size(); i+=2) {
        String strStart = list.get(i);
        String strEnd = list.get(i + 1);

        LocalDate dateStart = getLocalDateFromString(strStart, "yyyy-MM-dd");
        LocalDate dateEnd = getLocalDateFromString(strEnd, "yyyy-MM-dd");

        long dif = getDaysDif(dateStart, dateEnd);

        System.out.println(dif);
    }
}