public static void main(String[] args) {
    Calendar c = Calendar.getInstance();
    c.set(2013, 2, 30, 23, 0, 0);
    long start = c.getTimeInMillis();
    long oneHour = 1000 * 60 * 60;
    long t = start;
    for (long i = 0; i < 5; i++) {
        System.out.println(new Date(t));            
        t = t + oneHour;
    }
}