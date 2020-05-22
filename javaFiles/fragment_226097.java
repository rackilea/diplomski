static List<LocalDate> sortDates(List<String> datesStr, String format, boolean isAscending) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return datesStr.stream()
                   .map(str -> LocalDate.parse(str, formatter))
                   .sorted(isAscending ? Comparator.naturalOrder() : Comparator.reverseOrder())
                   .collect(Collectors.toList());
}