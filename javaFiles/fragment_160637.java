String strCurrentDate= "2016-07-13 13:10:00";
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date newDate = null;
  try {
      newDate = format.parse(strCurrentDate);
      format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
      String date = format.format(newDate);
      System.out.println(date);
  } catch (ParseException e) {
      e.printStackTrace();
  }