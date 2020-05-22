String string = "36/03/2017";
DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
format.setLenient(false);
try {
    Date date = format.parse(string);
    System.out.println(date);
} catch (ParseException e) {
     e.printStackTrace();
}