Pattern p = Pattern.compile("(\d{2}):(\d{2})");
Matcher m = p.matcher(userString);
if (m.matches() ) {
    String hourString = m.group(1);
    String minuteString = m.group(2);
    int hour = Integer.parseInt(hourString);
    int minute = Integer.parseInt(minuteString);

    if (hour >= 10 && hour <= 18) {
        ...
    }
}