Date oldfashionedDate = // some Date equal to 1 August 2018 at 00:00 in my time zone;
    LocalDate modernDate = oldfashionedDate.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    XMLGregorianCalendar gTest = DatatypeFactory.newInstance()
            .newXMLGregorianCalendar(modernDate.toString());
    System.out.println(gTest);