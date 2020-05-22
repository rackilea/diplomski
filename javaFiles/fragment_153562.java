try
    {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = format.parse("2014-01-22 13:24:03");
      String newdate = "" + date.getDate() + "." + date.getMonth() + " " + date.getHours() + "." + date.getMinutes(); 
    }
  catch( Exception e) {}