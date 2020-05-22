public String convertDateFormat(String format) {
        DateFormat df1 = new SimpleDateFormat("YYYY_MM_DD");
        DateFormat df2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        DateFormat dfResult = new SimpleDateFormat("DDMMMYYYY ");
        Date d = null;
        try {
            d = df1.parse(format);
            return dfResult.format(d);
        } catch (ParseException e) {
            System.err.println("impossible to parse to " + "YYYY_MM_DD");
        }
        try {
            d = df2.parse(format);
            return dfResult.format(d);
        } catch (ParseException e) {
            System.err.println("impossible to parse to " + "EEE MMM dd HH:mm:ss z yyyy");
        }
        return null;
    }