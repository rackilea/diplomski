DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
Date date = format.parse("2014-04-24 11:15:00");

GregorianCalendar cal = new GregorianCalendar();
cal.setTime(date);

XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

System.out.println(xmlGregCal);