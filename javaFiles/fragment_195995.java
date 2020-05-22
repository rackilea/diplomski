class Labels {

    private final Map<String, String> map;

    public Labels(Map<String, String> map) {
        Objects.requireNonNull(map);
        this.map = new HashMap<>();
        map.forEach((k, v) -> this.map.put(k.toLowerCase(), v));
    }

    public String getValue(String label) {
        return this.map.get(label.toLowerCase());
    }

    // toString
}