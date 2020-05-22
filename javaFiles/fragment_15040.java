Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(Calendar.DATE, 9);
cal.set(Calendar.MONTH, Calendar.NOVEMBER);
cal.set(Calendar.YEAR, 2013);
System.out.println("Start at " + cal.getTime());

cal.add(Calendar.MONTH, 3);
System.out.println("End at " + cal.getTime());