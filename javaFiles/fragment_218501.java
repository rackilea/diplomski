for (Map.Entry<String, String> entry1 : map1.entrySet()) {
    String value1 = entry1.getValue();
    for (Map.Entry<String, String> entry2 : map2.entrySet()) {
        String key2 = entry2.getKey();
        String value2 = entry2.getValue();
        String newValue = value1.replace('<' + key2 + '>', value2);
        map1.put(entry1.getKey(), newValue);
    }
}