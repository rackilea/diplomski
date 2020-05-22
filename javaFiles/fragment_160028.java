public static int compareDatesInTimeZone(Date d1, Date d2, TimeZone tz) {
    long t1 = d1.getTime();
    t1 += tz.getOffset(t1);
    long t2 = d2.getTime();
    t2 += tz.getOffset(t2);
    return Double.compare(t1 / 86400000, t2 / 86400000);
}