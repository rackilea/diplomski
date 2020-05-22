Calendar cal = Calendar.getInstance();
    Date currentLocalTime = cal.getTime();
    DateFormat date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");  
    date.setTimeZone(TimeZone.getTimeZone("GMT")); 
    String localTime = date.format(currentLocalTime); 

    long currenttime = Constant.retunlongdate(localTime);
    long fixtimejan = Constant.retunlongdate("01/01/1970 00:00:00 AM");

    long nTimeStamp = (currenttime - fixtimejan)/1000;
    System.out.println("and result is == " + nTimeStamp);

 public static long retunlongdate(String givenDateString)
        {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a"); 

        long timeInMilliseconds=0;
        try {
            Date mDate =sdf.parse(givenDateString);
              timeInMilliseconds = mDate.getTime();
            System.out.println("Date in milli :: " + timeInMilliseconds);
            return timeInMilliseconds;
        } catch (ParseException e) {
                    e.printStackTrace();
        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
        return timeInMilliseconds;
    }