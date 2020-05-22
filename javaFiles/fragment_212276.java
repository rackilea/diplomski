private static String printTime(long ticks) {
    long nano = ticks % 1000000000; ticks /= 1000000000;
    long sec  = ticks % 60;         ticks /= 60;
    long min  = ticks;

    return String.format("%02d mins %02d%09d secs", min, sec, nano);
}