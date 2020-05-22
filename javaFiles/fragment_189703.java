/**
 * Parses a date with the given formats. If the date could not be parsed then {@code null} is
 * returned.
 *
 * @param formats the possible date formats
 * @param dateString the date string to parse
 * @return the {@link java.util.Date} or {@code null} if the string could not be parsed.
 */
public static Date getDate(String[] formats, String dateString) {
  for (String format : formats) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
      return sdf.parse(dateString);
    } catch (ParseException ignored) {
    }
  }
  return null;
}