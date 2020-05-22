public void add(String key, String value) {
    if (dictionary.containsKey(key)) {
        dictionary.get(key).add(value);
    } else {
        List<String> valueList = new ArrayList<String>();
        valueList.add(value);
        dictionary.put(key, valueList);
    }
}