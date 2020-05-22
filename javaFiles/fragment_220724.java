Date date;
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
try {
    date = sdf.parse("30/12/90");
    System.out.println(date.toString());
} catch (ParseException e) {
    // Handle the exception
}