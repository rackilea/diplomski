public class Message {
    private static final AtomicLong ID_COUNTER = new AtomicLong();
    private final long timestamp;
    private final String text;
    private final long id;

    public Message(Date time, String text) {
        this(time, text, ID_COUNTER.incrementAndGet());
    }

    private Message(Date time, String text, long id) {
        this.timestamp = time.getTime(); // (a) Date is mutable & (b) better memory consumption
        this.text = text == null ? "" : text;
        this.id = id;
    }

    ... // getters & logic (if any)

    // Keep in mind - equals & compareTo should be in sync.
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        Message that = (Message) obj;
        return timestamp == that.timestamp && id == that.id && message.equals(that.message);
    }
}

public class MessageComparator implements Comparator<Message> {
    // Keep in mind - equals & compareTo should be in sync.
    public int compare(Message m1, Message m2) {
        if (m1 == null ? m2 == null : m1.equals(m2)) {
            return 0;
        }
        if (m1 == null) {
            return -1;
        }
        if (m2 == null) {
            return 1;
        }
        int c = Long.compare(m1.timestamp, m2.timestamp);
        if (c != 0) {
            return c;
        }
        c = m1.text.compareTo(m2.text);
        if (c != 0) {
            return c;
        }
        c = Long.compare(m1.id, m2.id);
        return c;
    }

    public Message minFrom(Date date) {
        return new Message(new Date(date.getTime()), null, -1);
    }

    public Message maxFrom(Date date) {
        return new Message(new Date(date.getTime() + 1), null, -1);
    }
}