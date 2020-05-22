Matcher m = p.matcher(theString);
if (m.find()) {
    String date = m.group(1);
    String name = m.group(2);
    System.out.println("Date: " + date + ", name: " + name);
}