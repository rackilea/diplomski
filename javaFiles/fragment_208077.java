public enum LoggerLevel {
    Low(0), Medium(1), High(2);

    private int value;
    public LoggerLevel(int val) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public void log (String mes, LoggerLevel lvl) {
    if (lvl.getValue() >= getLoggingLevel().getValue()) {
        // logic here
    }
}