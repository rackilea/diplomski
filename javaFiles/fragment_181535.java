public class AggregateException extends Exception {

    private final Exception[] secondaryExceptions;

    public AggregateException(String message, Exception primary, Exception... others) {
        super(message, primary);
        this.secondaryExceptions = others == null ? new Exception[0] : others;
    }

    public Throwable[] getAllExceptions() {

        int start = 0;
        int size = secondaryExceptions.length;
        final Throwable primary = getCause();
        if (primary != null) {
            start = 1;
            size++;
        }

        Throwable[] all = new Exception[size];

        if (primary != null) {
            all[0] = primary;
        }

        Arrays.fill(all, start, all.length, secondaryExceptions);
        return all;
    }

}