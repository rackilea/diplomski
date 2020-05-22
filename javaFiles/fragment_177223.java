public static Map<String, String> parseStringToMap(String payload) {
    Map<String, String> map = new HashMap<>();
    if (!payload.matches("[A-Za-z0-9]+=[A-Za-z0-9]+(\\|[A-Za-z0-9]+=[A-Za-z0-9]+)*")) {
        // return empty map
        return map;
    }

    // your original code here
}