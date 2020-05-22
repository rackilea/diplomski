import javax.xml.datatype.DatatypeFactory;
// ...
XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(
    int year,
    int month,
    int day,
    int hour,
    int minute,
    int second,
    int millisecond,
    int timezone)