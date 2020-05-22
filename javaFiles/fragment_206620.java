map.forEach((key, value) -> {
    if (key.endsWith("\"") && key.startsWith("\"")) {
        key = key.substring(1, key.length() - 1);
    }
    modifiedMap.put(key.trim().toUpperCase(), value);
});