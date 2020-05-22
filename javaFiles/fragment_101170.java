private static String mergeKeys(String input) {
    Map<String, StringBuilder> valKeys = new TreeMap<>();
    if (! input.isEmpty())
        for (String keyVal : input.split(",")) {
            int idx = keyVal.indexOf('_');
            String key = keyVal.substring(0, idx);
            String val = keyVal.substring(idx + 1);
            StringBuilder builder = valKeys.get(val);
            if (builder == null)
                valKeys.put(val, new StringBuilder(key));
            else
                builder.append('-').append(key);
        }
    StringJoiner result = new StringJoiner(",");
    for (Entry<String, StringBuilder> entry : valKeys.entrySet())
        result.add(entry.getValue().append('_').append(entry.getKey()).toString());
    return result.toString();
}