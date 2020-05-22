private String regex = ".*href=\"([^\"]*?)\".*";
private Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(result);
if (m.matches()) {
    String urlStr = m.group(1);
    links.add(urlStr);
}