for (Map.Entry<String, String> entry : map2.entrySet()) {
    String key2 = entry.getKey();
    String value2 = entry.getValue();
    if (key.startsWith(value1)) {
        return value2;
    }
}