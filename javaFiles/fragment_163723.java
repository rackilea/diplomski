private static final String FORMAT_STRING = "HH:mm:ss.SSSZ";    

public static Date getCurrentTimeOnly() {

    SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_STRING);

    String onlyTimeStr = formatter.format(new Date());
    return formatter.parse(onlyTimeStr);
}