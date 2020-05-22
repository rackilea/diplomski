public static void set(String key, String value) {
    command(config -> config.put(key, value));
}

public static void delete(String key) {
    command(config -> config.delete(key));
}