Locale locale = Locale.ENGLISH;
String shortPattern =
    DateTimeFormatterBuilder.getLocalizedDateTimePattern(
        FormatStyle.SHORT,
        null,
        IsoChronology.INSTANCE,
        locale
    );
System.out.println(shortPattern); // M/d/yy
if (shortPattern.contains("yy") && !shortPattern.contains("yyy")) {
    shortPattern = shortPattern.replace("yy", "yyyy");
}
System.out.println(shortPattern); // M/d/yyyy

DateTimeFormatter shortStyleFormatter = DateTimeFormatter.ofPattern(shortPattern, locale);
LocalDate today = LocalDate.now(ZoneId.of("America/Chicago"));
String output = today.format(shortStyleFormatter);
System.out.println(output); // 11/29/2016