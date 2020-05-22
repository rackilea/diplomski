Calendar mydate = new GregorianCalendar();
String mystring = "2013-06-04 23:59:59";
Date thedate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).parse(mystring);
mydate.setTime(thedate);
//breakdown
System.out.println("mydate -> "+mydate);
System.out.println("year   -> "+mydate.get(Calendar.YEAR));
System.out.println("month  -> "+(mydate.get(Calendar.MONTH)+1)); // <-- corrected
System.out.println("dom    -> "+mydate.get(Calendar.DAY_OF_MONTH));
System.out.println("dow    -> "+mydate.get(Calendar.DAY_OF_WEEK));
System.out.println("hour   -> "+mydate.get(Calendar.HOUR));
System.out.println("minute -> "+mydate.get(Calendar.MINUTE));
System.out.println("second -> "+mydate.get(Calendar.SECOND));
System.out.println("milli  -> "+mydate.get(Calendar.MILLISECOND));
System.out.println("ampm   -> "+mydate.get(Calendar.AM_PM));
System.out.println("hod    -> "+mydate.get(Calendar.HOUR_OF_DAY));