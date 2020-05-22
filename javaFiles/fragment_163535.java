public boolean isDatePass(DateTime date) {
    // Getting day of year and year of checked date:
    int checkedYear = date.getYear();
    int checkedDay = date.getDayOfYear();

    // Getting day of year and year of current date:
    DateTime currentTime = new DateTime(now, TimeZone.getTimeZone("IST"));
    int currentYear = currentTime.getYear();
    int currentDay = currentTime.getDayOfYear();

    if(checkedYear != currentYear) {
        return checkedYear < currentYear;
    }

    return checkedDay < currentDay;

}