Date date = new Date();                      // timestamp now
Calendar cal = Calendar.getInstance();       // get calendar instance
cal.setTime(date);                           // set cal to date
cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
cal.set(Calendar.MINUTE, 0);                 // set minute in hour
cal.set(Calendar.SECOND, 0);                 // set second in minute
cal.set(Calendar.MILLISECOND, 0);            // set millis in second
Date zeroedDate = cal.getTime();             // actually computes the new Date