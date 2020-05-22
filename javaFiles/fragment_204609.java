public final class CompareDatesValidator extends ValidatorSupport {
    private String fromDate; // getter and setter
    private String toDate;   // getter and setter    

    @Override
    public void validate(Object o) throws ValidationException {
        Date d1 = (Date)parse(fromDate, Date.class);
        Date d2 = (Date)parse(toDate, Date.class);

        if (d1==null || d2==null || d2.before(d1)){
            addActionError(getDefaultMessage());
        }
    }
}