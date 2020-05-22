String time = "14:35:59.99";
String timeRegex = "([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])(?:\\.([0-9]{1,3}))?";
Pattern pattern = Pattern.compile(timeRegex);
Matcher matcher = pattern.matcher(time);
if (matcher.matches()) {
    String hours = matcher.group(1);
    String minutes = matcher.group(2);
    String seconds = matcher.group(3);
    String miliSeconds = matcher.group(4);
    System.out.println(hours + ", " + minutes  + ", " + seconds + ", " + miliSeconds);
}