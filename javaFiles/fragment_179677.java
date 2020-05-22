XMLGregorianCalendar xcal = DatatypeFactory.newInstance()
                                           .newXMLGregorianCalendar("2015-08-08T18:46:16.6Z");
Date date = xcal.toGregorianCalendar().getTime();
System.out.println(xcal);
System.out.println(date);
System.out.println(new SimpleDateFormat("yyyyDDDHHmmssSSS").format(date));