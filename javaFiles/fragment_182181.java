public String getStringValue(int x) {
    for (Pair<Integer, Integer> range : mapping.keySet()) {
        if (x >= range.first && x <= range.second) {
            return mapping.get(range);
        }
    }
    return null;  // or throw exception, or whatever
}