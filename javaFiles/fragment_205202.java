String pattern = "dd.MM.yyyy";
SimpleDateFormat format = new SimpleDateFormat(pattern);

Date date = format.parse("3.9.1991");
System.out.println(date);
Period period = new Period(date.getTime(), (new Date()).getTime());
System.out.println(period.getYears());