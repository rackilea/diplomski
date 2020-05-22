Date d=new Date();
String formattedDate=format(d);

System.out.println("This is your date: "+formattedDate);  

public String format(String date){
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  return sdf.format(date);
}