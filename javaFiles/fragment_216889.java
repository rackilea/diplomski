String dateString = etDate.getText().toString();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
java.util.Date date;
try {
    date = df.parse(dateString);
    Timestamp datetime = new Timestamp(date.getTime());
} catch (ParseException e) {
    e.printStackTrace();
}