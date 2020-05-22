public static String getKey(String key) throws KeyNotFoundException {
    String value = getOptionalKey(key);
    if (value.equals("")) throw new KeyNotFoundException(key);
    return value;
}

public static String getOptionalKey(String key) {
    if (key.equals("something")) {
        return "great";
    } else {
        return "";
    }
}