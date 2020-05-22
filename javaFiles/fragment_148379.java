SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
    try {
        Date date1 = sdf.parse("00:00 02/11/2012");
        Date date2 = sdf.parse("10:23 10/12/2012");
        long differenceMilliSeconds = date2.getTime() - date1.getTime();
        long days = differenceMilliSeconds / 1000 / 60 / 60 / 24;
        long hours = (differenceMilliSeconds % ( 1000 * 60 * 60 * 24)) / 1000 / 60 / 60;
        long minutes = (differenceMilliSeconds % ( 1000 * 60 * 60)) / 1000 / 60;
        System.out.println(days+" days, " + hours + " hours, " + minutes + " minutes.");
    } catch (ParseException e) {
        e.printStackTrace();
    }