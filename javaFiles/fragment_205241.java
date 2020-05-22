public static final Map<String, String> initials = makeInitials();

private static Map<String, String> makeInitials() {
    Map<String, String> map = new HashMap<String, String>()
    map.put("AEN", "Alfred E. Newman");
    // etc.
    return Collections.unmodifiableMap(map);
}