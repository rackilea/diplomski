SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
String aDate = "03/17/40";
Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(Calendar.YEAR, 2000);
dateFormat.set2DigitYearStart(cal.getTime());
System.out.println(dateFormat.get2DigitYearStart());
System.out.println(dateFormat.parse(aDate));