String input = "März 2010";
// formatter with month name and year
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM yyyy");
Month month = null;
for (Locale loc : Locale.getAvailableLocales()) {
    try {
        // set the locale in the formatter and try to get the month
        month = Month.from(fmt.withLocale(loc).parse(input));
        break; // found, no need to parse in other locales
    } catch (DateTimeParseException e) {
        // can't parse, go to next locale
    }
}
if (month != null) {
    System.out.println(month.getValue()); // 3
}