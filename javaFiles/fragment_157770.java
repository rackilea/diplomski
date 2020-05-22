Calendar start = Calendar.getInstance();
start.set(MONTH, month - 1);  // month is 0 based on calendar
start.set(YEAR, year);
start.set(DAY_OF_MONTH, 1);
start.getTime();   // to avoid problems getTime make set changes apply
start.set(DAY_OF_WEEK, SUNDAY);
if (start.get(MONTH) <= (month - 1))  // check if sunday is in same month!
    start.add(DATE, -7);