public void dateValidation(ValueChangeEvent valueChangeEvent) throws ParseException {
    String fromDate = (String) AdfmfJavaUtilities.evaluateELExpression("#{bindings.inspFromDate.inputValue}");
    String toDate = (String) AdfmfJavaUtilities.evaluateELExpression("#{bindings.inspToDate.inputValue}");

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    formatter.setTimeZone(TimeZone.getTimeZone("IST"));

    if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty()) {

        java.util.Date inputFromDate = formatter.parse(fromDate);
        java.sql.Timestamp formattedFromDate = new Timestamp(inputFromDate.getTime());

        java.util.Date inputToDate = formatter.parse(toDate);
        java.sql.Timestamp formattedToDate = new Timestamp(inputToDate.getTime());

        if (formattedFromDate.compareTo(formattedToDate) > 0) {
            System.out.println("fromDate is greater than toDate");
            throw new AdfException("From Date should be less than To Date.!", AdfException.INFO);
        } else if (formattedFromDate.compareTo(formattedToDate) < 0) {
            System.out.println("fromDate is less than toDate");
        } else if (formattedFromDate.compareTo(formattedToDate) == 0) {
            System.out.println("fromDate is equal to toDate");             
        }
    }
}