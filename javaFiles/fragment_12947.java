XMLGregorianCalendar xgc = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar("1899-12-30T07:20:00");
    xgc.setTimezone(0);
    LocalTime time = xgc.toGregorianCalendar()
            .toZonedDateTime()
            .toLocalTime();
    System.out.println(time);