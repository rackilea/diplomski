private String formatDate(String date) {
    SimpleDateFormat formatFrom = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z ");

    java.util.Date tmpDate = formatFrom.parse(date);
    SimpleDateFormat formatTo = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
    return formatTo.format(tmpDate);
}