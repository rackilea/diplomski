GregorianCalendar startDate = new GregorianCalendar(2009, Calendar.JANUARY, 1);
public void setStart() {
  startDate.setLenient(false); 
  DateFormat df = new SimpleDateFormat("d/M/yyyy");
  df.format(startDate.getDate());
}