public static long HOURS = 60 * 60 * 1000;
public static long MINS = 60 * 1000;
public static long SECS = 1000;

public static void main(String[] args) {
    long time = (1 * HOURS) + (30 * MINS);

    double overflow = time;
    long h = time / HOURS;
    long overFlow = time % HOURS;
    long m = overFlow / MINS;
    overFlow = time % MINS;
    long s = overFlow / SECS;
    System.out.printf("%02d:%02d.%02d%n", h, m, s);
}