// get the label content as text (assuming you only have 1 label)
    Document doc = Jsoup.parse(driver.getPageSource());
    Element label = doc.select("label").first();
    String labelText = label.text();

    // get the relevant part (the date) from label content (between "on" and "from")
    String dateString = labelText.split("on")[1].split("from")[0].trim();

    // parse date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
    java.util.Date date = simpleDateFormat.parse(dateString);

    // create calendar from label date
    Calendar calendarLabel = new GregorianCalendar();
    calendarLabel.setTime(date);

    // create calendar for beginning of today in the default time zone
    //Calendar calendarToday = Calendar.getInstance();
    //  or in a timezone of your choice
    Calendar calendarToday = Calendar.getInstance(TimeZone.getTimeZone("Europe/Athens"));
    calendarToday.set(Calendar.HOUR_OF_DAY, 0);
    calendarToday.set(Calendar.MINUTE, 0);
    calendarToday.set(Calendar.SECOND, 0);
    calendarToday.set(Calendar.MILLISECOND, 0);

    // find out if label date is later than 0h of today
    System.out.println(calendarLabel.compareTo(calendarToday) >= 1);