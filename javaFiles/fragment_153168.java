Pattern p = Pattern.compile("Page (\\d+) of (\\d+)");
String text = "Page 14 of 203";
Matcher m = p.matcher(text);
if (m.find()) {
    System.out.println(m.group(1));
    System.out.println(m.group(2));
}