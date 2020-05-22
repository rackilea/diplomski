for (Entry<String, Object> entry: currentItem.entrySet()) {
    if (storage.containsKey(entry.getKey()) {
        storage.get(entry.getKey()).add(entry.getValue());

    } else {
        List<Object> newEntry = new ArrayList<Object>();
        newEntry.add(entry.getValue());
        storage.put(entry.getKey(), newEntry);
    }
}