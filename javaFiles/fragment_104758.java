private void someMethod(){
    final String dateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    Date firstDate = new Date();
    Date secondDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    try {
        firstDate = sdf.parse("2015-09-27 23:24:28.035");
        secondDate = sdf.parse("2015-09-27 23:24:28.036");
    } catch (ParseException pe) {
        pe.getMessage();
    }
    if(firstDate.after(secondDate)) {
        System.out.println("The first date is after the second date");
    } else{
        System.out.println("The first date is before the second date");
    }

}