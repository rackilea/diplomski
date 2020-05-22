public static String getFormattedDate(String date, String selectedDays, String time) {
    String dtStart = date;
    Calendar calendar = new GregorianCalendar();
    calendar.clear();
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy"); // This should be MMM and not MM according to the date format 08-aug-2013
    try {
      Date dateObject = format.parse(dtStart);
      System.out.println(date);
      calendar.setTime(dateObject);
      String[] hoursMins = time.split(":");
      int hours = Integer.valueOf(hoursMins[0]);
      int minutes = Integer.valueOf(hoursMins[1]);
      calendar.set(Calendar.HOUR_OF_DAY, hours);
      calendar.set(Calendar.MINUTE, minutes);
      calendar.set(Calendar.SECOND, 0); // Here, I have no idea where you get the seconds, so I just set them to 0
      calendar.add(Calendar.DAY_OF_MONTH, -Integer.valueOf(selectedDays)); // Add a minus sign to substract
      // System.out.println(calendar.getTime());
      // Use a SimpleDateFormat instead

      System.out.println(outputFormat.format(calendar.getTime()));
      // System.out.println(calendar.getTime());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return outputFormat.format(calendar.getTime());
  }