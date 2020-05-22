int m = Integer.parseInt(args[0]);
int d = Integer.parseInt(args[1]);
int y = Integer.parseInt(args[2]);

System.out.println("Finding day of week for "+m+"-"+d+"-"+y);

Calendar cal = new GregorianCalendar(y, m, d);
System.out.println("DAY_OF_WEEK: " + cal.get(Calendar.DAY_OF_WEEK));