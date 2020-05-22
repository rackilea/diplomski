public class TestJodaTime {

    public static void main(String[] args) {

        DateTime start = new DateTime(2012, 11, 11, 23, 30, 0, 0);
        DateTime end = new DateTime(2012, 11, 12, 1, 30, 0, 0);
        Interval interval = new Interval(start, end);
        Period toPeriod = interval.toPeriod();

        PeriodFormatter dateFormat = new PeriodFormatterBuilder()
                        .printZeroAlways().minimumPrintedDigits(2)
            .appendHours().minimumPrintedDigits(2)
            .appendSeparator(":")
            .appendMinutes().minimumPrintedDigits(2)
            .toFormatter();        
        System.out.println(toPeriod.toString(dateFormat));
    }
}