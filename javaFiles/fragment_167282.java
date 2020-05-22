public static void main(String... args) throws ParseException {
    String[] dates = { "2010-08-01","2010-09-02","2010-07-28","2010-08-29" };
    String[] dates2 = fillInDates(dates, "yyyy-MM-dd");
    System.out.println(Arrays.toString(dates2));
}

private static final long MILLIS_PER_DAY = 24L * 3600 * 1000;

private static String[] fillInDates(String[] dates, String format) throws ParseException {
    if (dates == null || dates.length < 1) return dates;

    SimpleDateFormat sdf = new SimpleDateFormat(format);
    long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    for (String date : dates) {
        long time = sdf.parse(date).getTime();
        if(min > time) min = time;
        if(max < time) max = time;
    }
    String[] dates2 = new String[(int) ((max - min)/MILLIS_PER_DAY+1)];
    for(int i=0;i<dates2.length;i++)
        dates2[i] = sdf.format(new Date(min + i * MILLIS_PER_DAY));
    return dates2;
}