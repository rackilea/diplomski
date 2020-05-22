private final ConcurrentHashMap<String, String> instance = 
    new ConcurrentHashMap<>(1);

private String getData() {
    final AtomicBoolean computed = new AtomicBoolean(false);
    String data = instance.computeIfAbsent("KEY", () -> { 
        String data = internalGetData(); 
        computed.set(true);
        return data;
    });
    if(computed.get()) {
       instance.clear();
    }
    return data;
}

private String internalGetData() {
    // ...
}