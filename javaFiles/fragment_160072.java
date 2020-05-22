public void run() throws IOException {

    Properties properties = ...;

    Map<String, Object> map = new TreeMap<>();

    for (Object key : properties.keySet()) {
        List<String> keyList = Arrays.asList(((String) key).split("\\."));
        Map<String, Object> valueMap = createTree(keyList, map);
        String value = properties.getProperty((String) key);
        value = StringEscapeUtils.unescapeHtml(value);
        valueMap.put(keyList.get(keyList.size() - 1), value);
    }

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(map);

    System.out.println("Ready, converts " + properties.size() + " entries.");
}

@SuppressWarnings("unchecked")
private Map<String, Object> createTree(List<String> keys, Map<String, Object> map) {
    Map<String, Object> valueMap = (Map<String, Object>) map.get(keys.get(0));
    if (valueMap == null) {
        valueMap = new HashMap<String, Object>();
    }
    map.put(keys.get(0), valueMap);
    Map<String, Object> out = valueMap;
    if (keys.size() > 2) {
        out = createTree(keys.subList(1, keys.size()), valueMap);
    }
    return out;
}