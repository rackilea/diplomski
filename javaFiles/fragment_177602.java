SimpleDateFormat formatGMT = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss.SSS a", Locale.US);

      formatGMT.setTimeZone(TimeZone.getTimeZone("GMT"));

      try 
      {
             date = formatGMT.parse("2016-09-06 05:18:06.023 PM");
      } 
      catch (ParseException e)
      {
             Crashlytics.log(Log.ERROR, "DB Insertion error", e.getMessage().toString());
             Crashlytics.logException(e);
             e.printStackTrace();
      }