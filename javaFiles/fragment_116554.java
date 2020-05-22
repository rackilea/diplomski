@SuppressWarnings("unchecked")
public static Map<String, Object> getMap(Map<String, Object> map, String key) {
    return (Map<String, Object>)map.get(key);
}

@SuppressWarnings("unchecked")
public static String getString(Map<String, Object> map, String key) {
    return (String)map.get(key);
}

@SuppressWarnings("unchecked")
public static Integer geInteger(Map<String, Object> map, String key) {
    return (Integer)map.get(key);
}

// you can add more methods for Date, Long, and any other types you know you'll get