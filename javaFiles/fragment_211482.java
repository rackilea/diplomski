XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar();
GregorianCalendar now = new GregorianCalendar();
xgc.setYear(now.get(Calendar.YEAR));
xgc.setMonth(now.get(Calendar.MONTH) + 1);
xgc.setDay(now.get(Calendar.DAY_OF_MONTH));
System.out.println(xgc);