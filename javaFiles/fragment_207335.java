private List<Date> getSaturdayListOfCurrentYear(){
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_YEAR, 1);

    int firstDayOfTheYear = calendar.get(Calendar.DAY_OF_WEEK);
    int rangeToFirstSaturday = 7 - firstDayOfTheYear;
    int currentSaturdayOfYear = 1 + rangeToFirstSaturday;
    int daysInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    List<Date> saturdays = new ArrayList<Date>();

    while(currentSaturdayOfYear <= daysInYear){
        calendar.set(Calendar.DAY_OF_YEAR, currentSaturdayOfYear);
        saturdays.add(calendar.getTime());
        currentSaturdayOfYear += 7;
    }

    return saturdays;
}