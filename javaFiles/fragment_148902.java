public static void main(String[] args) {
    Calendar cal1 = Calendar.getInstance();
    cal1.set(2011, 10, 10, 12, 00, 00);
    Date datenow = cal1.getTime();

    Calendar cal2 = Calendar.getInstance();
    cal2.set(2011, 10, 14, 15, 00, 00);
    Date datethen = cal2.getTime();

    // check for weekends
    long daynow = TimeUnit.MILLISECONDS.toDays(datenow.getTime());
    long daythen = TimeUnit.MILLISECONDS.toDays(datethen.getTime());
    long daydiff = daythen - daynow;
    long weekenddiff = daydiff / 7; // number of weekends

    if (cal1.get(Calendar.DAY_OF_WEEK) > cal2.get(Calendar.DAY_OF_WEEK)) {
        weekenddiff++;// we have a weekend but not another full week;
    }
    long secDiff = TimeUnit.SECONDS.convert(16, TimeUnit.HOURS);
    long weekendAdditionalSecDiff = TimeUnit.SECONDS.convert(16, TimeUnit.HOURS); // 16 additional hours for the weekend

    // 16 non-work hours between two shifts
    daydiff *= secDiff;
    daydiff += (weekenddiff * weekendAdditionalSecDiff); 
    long workDiffSeconds = TimeUnit.SECONDS.convert(
            datethen.getTime() - datenow.getTime(),
            TimeUnit.MILLISECONDS) - daydiff; 
    System.out.println("Difference in working hours is "
            + workDiffSeconds + " seconds");
    System.out.println("Difference in working hours is "
            + TimeUnit.HOURS.convert(workDiffSeconds, TimeUnit.SECONDS) + " hours");
}