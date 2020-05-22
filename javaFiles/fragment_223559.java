Map<String, Double> maksimum = new HashMap<String, Double>();

for (Record record : records) {
    for (Map.Entry<String, Double> recordEntry : record.getFeatures().entrySet()) {
        String key = recordEntry.getKey();
        Double value = recordEntry.getValue();

        Double initialValue = maksimum.get(key);
        if (initialValue == null) {
            maksimum.put(key, value);
        } else {
            maksimum.put(key, Math.max(value, initialValue));
        }
    }
}