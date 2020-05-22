// get dates using format/parse
    DateFormat format = new SimpleDateFormat("HH:mm");
    Date date1 = format.parse("13:00");
    Date date2 = format.parse("13:00");

    // use Date comparison methods
    boolean before = date1.before(date2);
    System.err.println(before);

    // use compareTo
    int compare = date1.compareTo(date2);
    System.err.println(compare);

    // get dates using Calendar
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR, 12);
    calendar.set(Calendar.MINUTE, 0);
    date1 = calendar.getTime();
    calendar.set(Calendar.HOUR, 13);
    date2 = calendar.getTime();