public static Map<String, Set<LocalDate>> createDateMapping(LocalDate min, LocalDate max) throws ParseException {
    DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateTimeFormatter wrongFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    final Map<String, Set<LocalDate>> inputMappings = new LinkedHashMap<>();

    for (LocalDate date = min; !date.isAfter(max); date = date.plusDays(1)) {
        final String incorrectlyFormattedDate = date.format(wrongFormat);
        final String key = targetFormat.format(targetFormat.parse(incorrectlyFormattedDate));
        if (!inputMappings.containsKey(key)) {
            inputMappings.put(key, new TreeSet<>());
        }
        inputMappings.get(key).add(date);
    }

    return inputMappings;
}