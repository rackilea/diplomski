public class EnhancedTimer {
    static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final long initialTime;

    public EnhancedTimer() {
        initialTime = System.nanoTime();
    }

    public long elapsedTime() {
        return System.nanoTime() - initialTime;
    }

    public String toString() {
        return formatTime(elapsedTime());
    }

    public static String formatTime(long timestamp) {
        return LocalTime.ofNanoOfDay(timestamp).format(DATE_FORMAT);
    }
}