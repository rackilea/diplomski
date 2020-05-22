Entry<String, DateTime> latestEntry = null;
for (Entry<String, DateTime> entry : myMap.entrySet()) {
    if (latestEntry == null || entry.getValue().isAfter(latestEntry.getValue()))
        latestEntry = entry;
}
String latestKey = (latestEntry != null ? latestEntry.getKey() : null);