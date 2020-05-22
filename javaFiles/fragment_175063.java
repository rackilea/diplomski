public Map<String, String> invertMap(Map<String, String> input) {
    Map<String, String> newMap = new LinkedTreeMap<String, String>(); // TODO Pick optimal storage class
    for (Map.Entry<String, String> entry : input.entrySet()) {
        newMap.put(entry.getValue(), entry.getKey());
    }
    return newMap;
}

// ...

Map<String, String> mappedValues = invertMap(new Gson().fromJson(myJsonString, Map.class));
String annieIndex = mappedValues.get("Annie");   // "1"
String olafIndex = mappedValues.get("Olaf");     // "2"