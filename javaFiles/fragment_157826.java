public enum Log {;

    private static final StringBuilder LOG = new StringBuilder();

    public static synchronized void append(String message) {
        LOG.append(message).append("\n");       
    }

    public static synchronized String getString() {
        return LOG.toString();
    }

    public static synchronized String getStringAndClear() {
        String s = LOG.toString();
        LOG.setLength(0);
        return s;
    }
}