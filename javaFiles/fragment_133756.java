DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        // Get a Date object from the date string
        Date myDate = dateFormat.parse(dateString);

        // this calculation may skip a day (Standard-to-Daylight switch)...
        //oneDayBefore = new Date(myDate.getTime() - (24 * 3600000));

        // if the Date->time xform always places the time as YYYYMMDD 00:00:00
        //   this will be safer.
        oneDayBefore = new Date(myDate.getTime() - 2);

        String result = dateFormat.format(oneDayBefore);