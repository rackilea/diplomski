String startTime = "12:00";

SimpleDateFormat sDateFormat = new SimpleDateFormat(
            "hh:mm");
String endTime = sDateFormat.format(new java.util.Date());

if (startTime.equals(endTime)) {
    timer.cancel();
}