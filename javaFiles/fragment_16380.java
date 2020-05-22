ThreadLocal<Map<String, String>> data = new ThreadLocal<Map<String, String>>() {
    @Override
    protected Map<String, String> initialValue() {
        return new HashMap<>();
    }
};