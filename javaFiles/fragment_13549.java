private boolean areEqual(String theDate, long currentTimeMillis) {
    try {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new SimpleDateFormat("dd-MMM-yyyy").parse(theDate));
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date(currentTimeMillis));
        return ((c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR))
                &&
           (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)));

    } catch (ParseException e) {
        e.printStackTrace();
        return false;
    }
}