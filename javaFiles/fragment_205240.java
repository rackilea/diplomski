public static final Map<String, String> initials;
static {
    Map<String, String> map = new HashMap<String, String>()
    map.put("AEN", "Alfred E. Newman");
    // etc.
    initials = Collections.unmodifiableMap(map);
}