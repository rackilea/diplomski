private static String mergeKeys(String input) {
    Map<String, String> valKeys = new LinkedHashMap<>();
    if (! input.isEmpty())
        for (String keyVal : input.split(",")) {
            int idx = keyVal.indexOf('_');
            String key = keyVal.substring(0, idx);
            String val = keyVal.substring(idx + 1);
            String prevKeys = valKeys.get(val);
            valKeys.put(val, prevKeys == null ? key : prevKeys + "-" + key);
        }
    String result = "";
    for (Entry<String, String> entry : valKeys.entrySet())
        result += "," + entry.getValue() + "_" + entry.getKey();
    return result.substring(1); // skip leading comma
}