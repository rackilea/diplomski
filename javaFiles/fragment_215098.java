SimpleDateFormat localDateFormat = new SimpleDateFormat("MMM dd yyyy - HH:mm");
    String oldstring = "Mar 19 2018 - 14:39";
    Date date=localDateFormat.parse(oldstring);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int hours = calendar.get(Calendar.HOUR_OF_DAY);
    int minutes = calendar.get(Calendar.MINUTE);
    int seconds = calendar.get(Calendar.SECOND);