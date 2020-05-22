public static List<String> returnListOfDatesBetweenTwoDates(java.util.Date fromDate,
                                                             java.util.Date toDate) {
    List<String> listOfDates = Lists.newArrayList();
    Calendar startCal = Calendar.getInstance(Locale.ENGLISH);
    startCal.setTime(fromDate);
    Calendar endCal = Calendar.getInstance(Locale.ENGLISH);
    endCal.setTime(toDate);
    while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()){
        java.util.Date date = startCal.getTime();
        listOfDates.add(new SimpleDateFormat("dd-MM-yyyy"
                                               , Locale.ENGLISH).format(date).trim());
        startCal.add(Calendar.DATE, 1);
    }
    return listOfDates;
}