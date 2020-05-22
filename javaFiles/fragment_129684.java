String startDate = "March 13, 2013";
SimpleDateFormat inputFormat = new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

try {
    Date d = inputFormat.parse(startDate);
    System.out.println(outputFormat.format(d));
} catch (ParseException e) {
    e.printStackTrace();
}