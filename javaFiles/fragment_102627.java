static final Map<String, Integer> VALUES_BY_NAME;
static {
    final Map<String, Integer> valuesByName = new HashMap<>();
    valuesByName.put("width", 5);
    valuesByName.put("potato", 2);
    VALUES_BY_NAME = Collections.unmodifiableMap(valuesByName);
}