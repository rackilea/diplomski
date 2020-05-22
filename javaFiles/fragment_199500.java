Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
int day = now.get(Calendar.DAY_OF_MONTH);
int hour = now.get(Calendar.HOUR_OF_DAY);
int minute = now.get(Calendar.MINUTE);
int second = now.get(Calendar.SECOND);
int millis = now.get(Calendar.MILLISECOND);

String monthup = String.valueOf(month);
String dayup = String.valueOf(day);
String hourup = String.valueOf(hour);
String minuteup = String.valueOf(minute);
String secondup = String.valueOf(second);
String millisup = String.valueOf(millis);

if (monthup.length() == 1) {
    monthup = "0" + monthup;
}
if (dayup.length() == 1) {
    dayup = "0" + dayup;
}
if (hourup.length() == 1) {
    hourup = "0" + hourup;
}
if (minuteup.length() == 1) {
    minuteup = "0" + minuteup;
}
if (secondup.length() == 1) {
    secondup = "0" + secondup;
}
if (millisup.length() == 1) {
    millisup = "0" + millisup;
}
if (millisup.length() == 2) {
    secondup = "00" + millisup;
}

String timewithmilsec = year + monthup + dayup + hourup + minuteup + secondup + millisup;
System.out.println(timewithmilsec);

try {
    DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    Date date = formatter.parse(timewithmilsec);
    System.out.println(date);
} catch (Exception e) {
    System.out.println(e);
}