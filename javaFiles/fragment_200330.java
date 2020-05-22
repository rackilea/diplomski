public static long getDate() {
    Calendar d1 = new GregorianCalendar(1989, 11, 31, 0, 0, 0);
    Date today = new Date();
    long diff = Math.abs(today.getTime() - d1.getTime().getTime());
    return (diff/1000);
}