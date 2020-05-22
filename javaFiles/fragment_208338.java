public Date getDaysAheadCurrentDate(int numberOfDaysAhead) {
    if (numberOfDaysAhead <= 0) {
        throw new IllegalArgumentException("The number of days ahead must be a positive integer.");
    }
    Calendar cal = Calendar.getInstance();
    // add the number of days before creating the java.sql.Date instance.
    cal.add(Calendar.DATE, numberOfDaysAhead);
    Date date = java.sql.Date.valueOf( 
            cal.get(Calendar.YEAR) + ":" + 
            cal.get(Calendar.MONTH) + ":" + 
            cal.get(Calendar.DATE) );
    return date;
}