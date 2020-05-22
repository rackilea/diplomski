Pattern p = Pattern.compile("^.*:macapp=(\\d+)$");
Matcher m = p.matcher(s);
if (m.find()) {
  int n = Integer.valueOf(m.group(1));
  ...
}