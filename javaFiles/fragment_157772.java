public static void main(String[] args) {
    int month = 8, year = 2016; 

    Calendar start = Calendar.getInstance();
    start.set(MONTH, month - 1);  // month is 0 based on calendar
    start.set(YEAR, year);
    start.set(DAY_OF_MONTH, 1);
    start.getTime();
    start.set(DAY_OF_WEEK, SUNDAY);
    if (start.get(MONTH) <= (month - 1))  
        start.add(DATE, -7);

    System.out.println(printCalendar(start));

    Calendar end = Calendar.getInstance();
    end.set(MONTH, month);  // next month 
    end.set(YEAR, year);
    end.set(DAY_OF_MONTH, 1);
    end.getTime();
    end.set(DATE, -1);
    end.set(DAY_OF_WEEK, SATURDAY);
    start.getTime();
    if (end.get(MONTH) != month)  
        end.add(DATE, + 7);

    System.out.println(printCalendar(end));
}