public class Test {

    static class TimeContainer {
        private static final long second = 1000;
        private static final long minute = 60 * second;
        private static final long hour = 60 * minute;
        private static final long day = 24 * hour;

        private final long starttime;
        private final long endtime;

        public TimeContainer(long startHour, long startMinutes, long endHour, long endMinutes) {
            starttime = startHour * hour + startMinutes * minute;
            endtime = endHour * hour + endMinutes * minute + minute; 
        }

        public boolean test(long timeToTest) {
            long hoursInDay = timeToTest % day;
            return hoursInDay >= starttime && hoursInDay <= endtime;
        }
    }

    static class JodaContainer {
        private final LocalTime starttime;
        private final LocalTime endtime;

        public JodaContainer (LocalTime start, LocalTime end) {
            starttime = start;
            endtime = end;
        }

        public boolean test(long timeToTest) {
            LocalTime lt = new LocalTime(timeToTest);
            return lt.equals(starttime) || lt.equals(endtime) || (lt.isAfter(starttime) && lt.isBefore(endtime));
        }
    }

    public static void main(String[] args) {

        long[] testTimes1 = new long[5];
        long[] testTimes2 = new long[5];

        Calendar test1 = Calendar.getInstance(TimeZone.getTimeZone("Etc/Zulu"));
        Calendar test2 = Calendar.getInstance();

        TimeContainer timeContainer = new TimeContainer(13, 0, 13, 10);
        JodaContainer jodaContainer = new JodaContainer(new LocalTime(13,0), new LocalTime(13,10));

        test1.set(2010, 10, 5, 13, 6, 20);
        test2.set(2010, 10, 5, 13, 6, 20);
        testTimes1[0] = test1.getTimeInMillis();
        testTimes2[0] = test2.getTimeInMillis();

        test1.set(2012, 9, 6, 13, 1, 24);
        testTimes1[1] = test1.getTimeInMillis();
        test2.set(2012, 9, 6, 13, 1, 24);
        testTimes2[1] = test2.getTimeInMillis();

        test1.set(2010, 11, 22, 13, 9, 1);
        testTimes1[2] = test1.getTimeInMillis();
        test2.set(2010, 11, 22, 13, 9, 1);
        testTimes2[2] = test2.getTimeInMillis();

        test1.set(2012, 10, 5, 13, 26, 20);
        testTimes1[3] = test1.getTimeInMillis();
        test2.set(2012, 10, 5, 13, 26, 20);
        testTimes2[3] = test2.getTimeInMillis();

        test1.set(2010, 10, 5, 14, 6, 20);
        testTimes1[4] = test1.getTimeInMillis();
        test2.set(2010, 10, 5, 14, 6, 20);
        testTimes2[4] = test2.getTimeInMillis();

        for (long t : testTimes1) {
            System.out.println(t + "=" + timeContainer.test(t));
        }
        System.out.println();
        for (long t : testTimes2) {
            System.out.println(t + "=" + jodaContainer.test(t));
        }

    }

 }