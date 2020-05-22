DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
    .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    .appendOptional(DateTimeFormatter.ofPattern("MM/dd/yy"))
    .appendOptional(DateTimeFormatter.ofPattern("MMM dd, yyyy"))
    // use English locale
    .toFormatter(Locale.ENGLISH);

System.out.println(LocalDate.parse("2017-08-29", DATE_FORMATTER).atStartOfDay());
System.out.println(LocalDate.parse("08/29/17", DATE_FORMATTER).atStartOfDay());
System.out.println(LocalDate.parse("Aug 29, 2017", DATE_FORMATTER).atStartOfDay());