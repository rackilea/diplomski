public List<String> subtractMonths(String[][] str) {
    YearMonth lastMonth = YearMonth.now(clock).minusMonths(1);
    List<String> ids = Arrays.stream(str)
            .filter(pair -> YearMonth.parse(pair[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    .isBefore(lastMonth))
            .map(pair -> pair[0])
            .collect(Collectors.toList());
    return ids;
}