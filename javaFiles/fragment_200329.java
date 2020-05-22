public static long getDate() {
    Date d1 = new Date(1989, 12, 31, 12, 0, 0);
    Date today = new Date();
    long diff = Math.abs(today.getTime() - d1.getTime());
    return (diff/1000);
}