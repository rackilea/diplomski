public static String getTimeDate(long timestamp){
    try{
        DateFormat dateFormat = getDateTimeInstance();
        Date netDate = (new Date(timestamp));
        return dateFormat.format(netDate);
    } catch(Exception e) {
        return "date";
    }
}