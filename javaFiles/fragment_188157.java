String pattern = "DD-MMM-YYYY";
DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
    .parseCaseInsensitive()
    // replace DD and YYYY with the lowercase versions
    .appendPattern(pattern.replace("DD", "dd").replaceAll("YYYY", "yyyy"))
    .toFormatter(Locale.ENGLISH);
// do the same for output format if needed