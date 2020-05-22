try {
    String dateString = "30/09/2014";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date date = sdf.parse(dateString);

    long startDate = date.getTime();

} catch (ParseException e) {
    e.printStackTrace();
}