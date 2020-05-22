public boolean isDatePass(Date date) {
    Calendar calendar = Calendar.getInstance();

    // Getting day of year and year of checked date:
    calendar.setTime(date);
    int checkedYear = calendar.get(Calendar.YEAR);
    int checkedDay = calendar.get(Calendar.DAY_OF_YEAR);

    // Getting day of year and year of current date:
    calendar.setTime(new Date());
    int currentYear = calendar.get(Calendar.YEAR);
    int currentDay = calendar.get(Calendar.DAY_OF_YEAR);

    if(checkedYear != currentYear) {
        return checkedYear < currentYear;
    }

    return checkedDay < currentDay;

}