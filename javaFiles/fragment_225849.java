String date="10-12-1999";
String [] s1=date.split("-");
int day=Integer.parseInt(s1[0]);
int month=Integer.parseInt(s1[1]);
int year=Integer.parseInt(s1[2]);
System.out.println("Day->"+day+"    Month->"+month+"    Year->"+year);