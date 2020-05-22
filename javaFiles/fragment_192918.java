Object lock = new Object();
StringBuilder buf = new StringBuilder();

public void appendMessage(String message) {
    synchronized(lock) {
        buf.append("INFO: ").append(message).append(System.lineSeparator());
    }
}