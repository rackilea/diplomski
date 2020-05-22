private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
private final SimpleDateFormat sqldateFormat = new SimpleDateFormat("yyyy-mm-dd");

public java.sql.Date changeDate(String date) {      
    String newDate = "";
    try {
        java.util.Date d = dateFormat.parse(date);
        newDate = sqldateFormat.format(d);
    } catch (ParseException e) {
        e.printStackTrace();
    }                   
    return java.sql.Date.valueOf(newDate);
}