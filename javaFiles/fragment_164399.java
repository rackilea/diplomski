public static Date jsDateStringToJavaDate(String jsDateString) throws ParseException{

    String[] arrStrDateParts = jsDateString.split(" ");
    SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
    sdf.setTimeZone(TimeZone.getTimeZone(arrStrDateParts[5].substring(0,6)+":"+arrStrDateParts[5].substring(6)));
    return sdf.parse(arrStrDateParts[0]+" "+arrStrDateParts[1]+" "+arrStrDateParts[2]+" "+arrStrDateParts[3]+" "+arrStrDateParts[4]);       
}