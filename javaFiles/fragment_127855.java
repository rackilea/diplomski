public abstract class TimeStamped implements Comparable<TimeStamped>{

@Override
public int compareTo(TimeStamped timedObject) {
    return Long.compare(this.getTimeStamp(), timedObject.getTimeStamp());
}

public abstract long getTimeStamp();

}