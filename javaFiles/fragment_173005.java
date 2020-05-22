class Wrapper implements Comparable<Wrapper> {
    long priority;
    Message message;

    Wrapper(long priority, Message message) {
        this.priority = priority;
        this.message = message;
    }

    @Override
    public int compareTo(Wrapper w) {
        return Long.compare(priority, w.priority);
    }
}