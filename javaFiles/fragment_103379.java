Pattern p = Pattern.compile("(\d*):(\d*)\s(AM|PM)");
Matcher m = p.matcher(str);
if (m.find()) {
    String hours = m.group(1);
    String minutes = m.group(2);
}