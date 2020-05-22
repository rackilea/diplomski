for (Map<String, String> innerEntry : childDataItem) {
    for (String key : innerEntry.keySet()) {
        String value = innerEntry.get(key);
        Log.d("MyLogs", "(childDataItem)key = " + key);
        Log.d("MyLogs", "(childDataItem)value = " + value);
    }
}