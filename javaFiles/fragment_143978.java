SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String date = "1938-06-11";
java.util.Date utilDate = null;
try {
  utilDate = formatter.parse(date);
} catch (ParseException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
System.out.println("date:" + date);
System.out.println("utilDate:" + utilDate);