public enum EventType {
    START,
    END;
}

public class EventPoint implements Comparable<EventPoint> {
    public EventType type;
    public double x;
    public Circle circle;
    public Interval interval;

    public EventPoint(EventType type, double x,
            Circle circle, Interval interval) {
        this.type = type;
        this.x = x;
        this.circle = circle;
        this.interval = interval;
    }

    /**
     * Compare this EventPoint with another. This is used by the priority
     * queue to determine the "minimum" event.
     */
    public int compareTo(EventPoint other) {
        return Double.compare(x, other.x);
    }

    /** Creates a start event, with a circle. */
    public static EventPoint start(double x, Circle circle) {
        return new EventPoint(START, x, circle, null);
    }

    /** Creates an end event, with an interval. */
    public static EventPoint end(double x, Interval interval) {
        return new EventPoint(END, x, null, interval);
    }
}