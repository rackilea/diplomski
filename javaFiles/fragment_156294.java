static String hackIt(String str, String key) {
  Pattern p = Pattern.compile("\\b" + Pattern.quote(key) + "=\"([^\"]*)\"");
  Matcher m = p.matcher(str);
  if (m.find()) {
      return m.group(1);
  } else {
      return null;
  }
}