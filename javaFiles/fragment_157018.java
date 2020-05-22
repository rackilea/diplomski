Timestamp timestamp = Timestamp.valueOf("1800-01-01 00:00:00.0");

    Timestamp ctimestamp = new Timestamp(System.currentTimeMillis());
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(timestamp);

    int firstYearValue = calendar.get(Calendar.YEAR);

    calendar.setTime(ctimestamp);
    int secondYearValue = calendar.get(Calendar.YEAR);

    int diff = secondYearValue - firstYearValue;
    System.out.println(diff);