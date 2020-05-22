int groupByDays(List<Date> dateList, int dayToMatch) {   //dayToMatch can be defined as Calendar.TUESDAY or Calendar.MONDAY ...
    int counter = 0;
    for (Date date : dateList) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (day == dayToMatch)
           counter++;
        System.out.println("Day is : "+day); //This will return the day index compare with actual value to get the DAY in string format
    }
    return counter;
}