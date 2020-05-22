public static void put(String key, String value) {
    data.get().put(key, value);
}

public static String get(String key) {
    return data.get().get(key);
}