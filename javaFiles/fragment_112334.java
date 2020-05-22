private int monthCount = 0; // +getter/setter

private List<Date> dateList = new ArrayList<Date>(); // +getter/setter

public void listenerMonthCount(SlideEndEvent ae) {
    dateList.clear(); // clear the list to remove entries from possible old runs
    if (monthCount > 0) {
        Date now = new Date();
        dateList.add(now); // add first date
        Calendar cal = Calendar.getInstance();
        for (int i = 1; i < monthCount; i++) {
            cal.setTime(dateList.get(dateList.size() - 1)); // get last date from list and set calendar
            cal.add(Calendar.MONTH, 1);// add one month
            dateList.add(cal.getTime()); // add calculated date
        }
    }
}