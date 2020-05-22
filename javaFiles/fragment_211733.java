static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy"); //specifiy the 
//representation pattern. This is for example. You can construct it more accurate:
//display the hours, mins, secs, etc. Also you can specify your own delimiters. 
//See more at docs below

static { //upd: set the proper timezone
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
}

private static String getHumanizedTime(int seconds) {
    long timeInMillis = seconds * 1000; //Date object is designed for millis
    Date date = new Date(timeInMillis);
    return dateFormat.format(date);
}