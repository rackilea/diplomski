// Formatter for readable comparison
    DateFormat sdf = new SimpleDateFormat("MM dd yyyy", Locale.getDefault());

    // Today
    Calendar now = Calendar.getInstance();
    Date dateToday = new Date();
    dateToday.setTime(now.getTimeInMillis());

    // 39 weeks from today
    Date futureDate = new Date();
    // Calendar supports roll over with year so no need to worry about modifying year separate
    now.add(Calendar.WEEK_OF_YEAR, 39); 
    futureDate.setTime(now.getTimeInMillis());

    // Print out for comparison
    System.out.println(sdf.format(dateToday));
    System.out.println(sdf.format(futureDate));