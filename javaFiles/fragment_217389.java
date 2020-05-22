new CacheLoader<String, MyClass>() {
    @Override
    public MyClass load(String key) {
        return getValue(key); // instead of return getValue(cacheKey);
    }
}