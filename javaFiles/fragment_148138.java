TreeMultiset<DateTime> eventTimes;

public int eventsSince(int seconds) {
    return eventTimes.tailMultiset(
        DateTime.now().minus(Seconds.seconds(seconds)),
        BoundType.CLOSED
    ).size();
}