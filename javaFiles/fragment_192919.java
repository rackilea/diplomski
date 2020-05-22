^www.test.com/#!search/(.+)/cat=(.+)/$

Pattern p = Pattern.compile("^www.test.com/#!search/(.+)/cat=(.+)/$");
Matcher m = p.matcher(url);

while(m.find()) {
    String keyword = m.group(1);
    String cat = m.group(2);
}