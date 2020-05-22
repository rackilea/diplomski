Scanner s=new Scanner(System.in);
String dob=s.next("[12][0-9]{3}-[0-9]{2}-[0-3][0-9]");
int yearDOB = Integer.parseInt(dob.substring(0, 4)); 
int monthDOB = Integer.parseInt(dob.substring(5, 7)); 
int dayDOB = Integer.parseInt(dob.substring(8, 10));
Calendar c=Calendar.getInstance();
int thisYear = c.get(Calendar.YEAR);
int thisMonth = c.get(Calendar.MONTH)+1;
int thisDay = c.get(Calendar.DAY_OF_MONTH);
// the rest is up to you