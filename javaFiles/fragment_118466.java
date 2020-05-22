private static final String regex = "(@.*?)(?:\\s|$)";
private static final Pattern pattern = Pattern.compile(regex);

private static String replaceAnnotationsWithLength(String string) {
  Matcher matcher = pattern.matcher(string);

  while (matcher.find()) {
    string = string.replace(matcher.group(1), Integer.toString(matcher.group(1).length() - 1));
  }

  return string;
}