class ThingyFactory {
    private Map<String, Supplier<Thingy<?, ?>>> providers = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public <K, V> Supplier<Thingy<K, V>> getInstance(String classname) {
        return () -> (Thingy<K, V>) providers.get(classname);
    }
}