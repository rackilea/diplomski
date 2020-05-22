SortedMap<DateTime, Integer> eventCounts = initEventMap();

public SortedMap<DateTime, Integer> initEventMap() {
    TreeMap<DateTime, Integer> map = new TreeMap<>();
    //prime the map to make subsequent operations much cleaner
    map.put(DateTime.now().minus(Seconds.seconds(1)), 0);
    return map;
}

private long totalCount() {
    //you can handle the edge condition here
    return eventCounts.getLastEntry().getValue();
}

public void logEvent() {
    eventCounts.put(DateTime.now(), totalCount() + 1);
}