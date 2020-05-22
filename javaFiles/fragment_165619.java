SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
Date d = null;
try {
    //convert string to date
    d = inputFormat.parse(input);
} catch (ParseException e) {
    System.out.println("Date Format Not Supported");
    e.printStackTrace();
}