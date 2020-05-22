String month = sc.nextLine();
int iMonth = -1;
if(month.equalsIgnoreCase("January"))  iMonth = 0;
else if(month.equalsIgnoreCase("February")) iMonth = 1;
// and so on ...
Calendar cal = new GregorianCalendar(2011, iMonth, 1);