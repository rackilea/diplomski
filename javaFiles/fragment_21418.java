String href = "http://services.runescape.com/m=itemdb_rs/viewitem.ws?obj=4151";
Pattern p = Pattern.compile("\\?obj=(\\d+)");
Matcher m = p.matcher(href);
if (m.find()) {
    System.out.println(m.group(1));
}