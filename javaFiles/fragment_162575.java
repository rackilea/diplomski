Date date = new Date();
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
    c.add(Calendar.DATE, -i - 7);
    Date start = c.getTime();
    c.add(Calendar.DATE, 6);
    Date end = c.getTime();
    System.out.println(start + " - " + end);