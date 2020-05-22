static List<LocalDate> sortDates(List<String> datesStr, String format, boolean isAscending) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    List<LocalDate> dates = new ArrayList<>();
    for (String str : datesStr) {
        LocalDate date = LocalDate.parse(str, formatter);
        dates.add(date);
    }
    dates.sort(isAscending ? Comparator.naturalOrder() : Comparator.reverseOrder());
    return dates;
}