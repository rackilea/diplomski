public static String format(String pattern, Locale locale, Object... args) {
  final String emptyPattern = "";
  final FieldPosition zero = new FieldPosition(0);
  MessageFormat fmt = new MessageFormat(emptyPattern, locale);
  StringBuffer buf = new StringBuffer(); // I just love it...

  fmt.applyPattern(pattern);
  fmt.format(args, buf, zero);

  return buf.toString();
}