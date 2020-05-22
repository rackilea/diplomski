Integer toFind = new Integer(1);
for (Map.Entry<String, Integer> entry: myMap.entries()) {
    if (toFind.equals(entry.getValue())) {
        // entry.getKey() is the first match
    }
}
// handle not found case