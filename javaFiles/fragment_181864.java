Locale russian = new Locale("ru");
String[] newMonths = {
  "января", "февраля", "марта", "апреля", "мая", "июня", 
  "июля", "августа", "сентября", "октября", "ноября", "декабря"};
DateFormatSymbols dfs = DateFormatSymbols.getInstance(russian);
dfs.setMonths(newMonths);
DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, russian);
SimpleDateFormat sdf = (SimpleDateFormat) df;
sdf.setDateFormatSymbols(dfs);

Date jud = new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-28");
String month = sdf.format(jud);
System.out.println(month); // output: 28 февраля 2014 г.