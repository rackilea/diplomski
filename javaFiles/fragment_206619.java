map.forEach((key, value) -> {
    key = key.toUpperCase();
    if (key.endsWith("\"") && key.startsWith("\"")) {
        modifiedMap.put(key.substring(1, key.length() - 1), value);
    } else {
        modifiedMap.put(key.trim(), value);
    }
});