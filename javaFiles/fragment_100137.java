Entry<String, DateTime> latestEntry = null;
for (Entry<String, DateTime> entry : myMap.entrySet()) {
    if (latestEntry == null || entry.getValue().isAfter(latestEntry.getValue()))
        latestEntry = entry;
}
myMap.clear();
if (latestEntry != null)
    myMap.put(latestEntry.getKey(), latestEntry.getValue());