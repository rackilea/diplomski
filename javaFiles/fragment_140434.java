String sTime = "08:00";
    String sOffset ="00:07";
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
    Date dtTime = null;
    try {
        dtTime = dateFormat.parse(sTime);
    } catch (ParseException e) {
        // handle exception
        return;
    }

    String[] offsetHrsMins = null;
    NumberFormat numberFormat = NumberFormat.getNumberInstance();
    long offsetMillis = 0;
    try {
        offsetHrsMins = sOffset.split(":");
        long offsetHrs = (Long) numberFormat.parse(offsetHrsMins[0]);
        long offsetMins = (Long) numberFormat.parse(offsetHrsMins[1]);
        offsetMillis = 1000 * 60 * ((offsetHrs * 60) + offsetMins);
    } catch (ParseException e) {
        // handle exception
        return;
    }

    long lTime = dtTime.getTime();

    System.out.println("Adding minutes: " + dateFormat.format(new Date(lTime + offsetMillis)));
    System.out.println("Subtracting minutes: " + dateFormat.format(new Date(lTime - offsetMillis)));