Pattern p = Pattern.compile("\\{(\\w*)\\}");

Matcher m = p.matcher("{some_interesting_token}");

String token = null;
if (m.matches()) {
 token = m.group();
}