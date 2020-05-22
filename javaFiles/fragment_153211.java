public static boolean validateDate(String dateString){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    try {
        sdf.parse(dateString);
        return true;
    } catch (ParseException ex) {
        return false;
    }
}