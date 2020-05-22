private final String pattern = "dd-MMM-yyyy";
private final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

public boolean validateDate(String date) {
    try {
        sdf.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
}