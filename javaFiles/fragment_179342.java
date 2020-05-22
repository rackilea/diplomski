static public String getTimeStamp(){

        String timeFormat = "HH.mm.ss.SSS ";
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        return sdf.format(now).substring(timeFormat.length() - 4);         
    }