DateTimeFormatter fmt = new DateTimeFormatterBuilder()
    // case insensitive
    .parseCaseInsensitive()
    // pattern with full month name (MMMM)
    .appendPattern("MMMM yyyy")
    // set locale
    .toFormatter(new Locale("es", "ES"));
// now it works
fmt.parse("Mayo 2017");