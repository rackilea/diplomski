String birthday = "25/05/1973";
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
try {
    Date date = format.parse(birthday);
    System.out.println("date = " + date);
}
catch (ParseException e) {
     //date was bad format
}