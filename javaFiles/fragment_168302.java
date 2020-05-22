static class CustomLongPoolingMap {
    private static final Interner<Long> LONG_POOL = Interners.newStrongInterner();
    private final Map<Long, String> map = new HashMap<>();

    @JsonAnySetter
    public void addEntry(String key, String value) {
        map.put(LONG_POOL.intern(Long.parseLong(key)), value);
    }

    public Map<Long, String> getMap() {
        return map;
    }
}