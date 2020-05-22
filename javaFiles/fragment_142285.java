` see code below:        
    public XMLGregorianCalendar formatToGregorianDate(String myDate) {
    //actual Date format should be "dd-MMM-yy", but SimpleDateFormat accepts only this one
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;

    try {
        //Date is accepted only without time or zone
        date = simpleDateFormat.parse(myDate.substring(0, 10));
    } catch (ParseException e) {
        System.out.println("Date can't be parsed to required format!");
        e.printStackTrace();
    }

    GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
    gregorianCalendar.setTime(date);
    XMLGregorianCalendar result = null;
    try {
        result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        //date must be sent without time
        result.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
    } catch (DatatypeConfigurationException e) {
        System.out.println("XMLGregorianCalendar can't parse the Date format!");
        e.printStackTrace();
    }

    return result;
}`