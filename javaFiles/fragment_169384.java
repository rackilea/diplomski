IdentifierType identifier = new IdentifierType();
DateType date = new DateType();

String identifierValue = getPropertyOrNull(identifier, IdentifierType::getValue);

XMLGregorianCalendar dateValue = getPropertyOrNull(date, DateType::getValue);