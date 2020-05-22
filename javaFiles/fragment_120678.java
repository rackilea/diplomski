public static void main(String[] args) {
    PeriodFormatter hoursMinutesSeconds = new PeriodFormatterBuilder()
    .printZeroRarelyLast()
    .appendHours().appendSuffix(" hour", " hours")
    .appendSeparator(", ", " and ")
    .appendMinutes()
    .appendSuffix(" minute", " minutes")
    .appendSeparator(" and ")
    .appendSeconds()
    .appendSuffix(" second", " seconds")
    .toFormatter();
     System.out.println(hoursMinutesSeconds.print(new Period(0, 0, 0, 0)));
}