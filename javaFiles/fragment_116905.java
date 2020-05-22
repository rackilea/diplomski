public static void main(String[] args) throws Exception {
  System.out.println(parseWithOptionalTZ("2014-08-08+02:00"));
  System.out.println(parseWithOptionalTZ("2014-08-08"));
}

private static DateTime parseWithOptionalTZ(String date) {
  DateTimeFormatter[] formatters = { 
      DateTimeFormat.forPattern("YYYY-MM-dd"),
      DateTimeFormat.forPattern("YYYY-MM-ddZ") 
  };

  for (DateTimeFormatter dateTimeFormatter : formatters) {
    try {
      return dateTimeFormatter.parseDateTime(date);
    } catch (IllegalArgumentException e) {
      // ignore
    }
  }

  throw new IllegalArgumentException("Could not parse: " + date);
}