public boolean checkDate(String dateInString, String format){
    try {
        return DateUtils.isToday(new SimpleDateFormat(format).parse(dateInString)); 
    } catch (ParseException e) {
        return false;
    }
}