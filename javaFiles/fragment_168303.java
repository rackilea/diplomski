public static class MyCustomKeyDeserializer extends KeyDeserializer {
    private static final Interner<Long> LONG_POOL = Interners.newStrongInterner();
    @Override
    public Long deserializeKey(String key, DeserializationContext ctxt) {
        return LONG_POOL.intern(Long.parseLong(key));
    }
}