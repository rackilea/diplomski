DatatypeFactory df = DatatypeFactory.newInstance();
GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();

Date messageDate = pojoClass.getMessageDate().toGregorianCalendar().getTime();
cal.setTime(messageDate);
XMLGregorianCalendar xCal = df.newXMLGregorianCalendar(cal);
pojoClass.setMessageDate(xCal);