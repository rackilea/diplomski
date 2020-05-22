private String formatDate(String date) throws ParseException {
    SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentDate = inputDate.parse(date);

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = formatter.format(currentDate);
    return formattedDate;
}