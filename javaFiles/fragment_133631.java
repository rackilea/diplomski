SimpleDateFormat  format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");  

    try {  
        Date cookiedate = format.parse("Tue Apr 29 11:40:55 GMT+04:00 2014");  

        Calendar currentDate = Calendar.getInstance();

        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        cookiedate = format.parse(format.parse(cookiedate));

        String dateNow = format.format(currentDate.getTime());
        Date currDate =  format.parse(dateNow);

        if (currDate.getTime() > cookiedate.getTime()) {
            return true;
        }


    } catch (ParseException e) {  
        e.printStackTrace();  
    }