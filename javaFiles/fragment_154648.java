public void record(String key, String value) {
    List<String> values = entries.get(key);
    if (values == null) {
        entries.putIfAbsent(key, Collections.synchronizedList(new ArrayList<String>()));
        // At this point, there will definitely be a list for the key.
        // We don't know or care which thread's new object is in there, so:
        values = entries.get(key);
    }
    values.add(value);
}