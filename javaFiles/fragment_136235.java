private final AtomicReference<Map<String, String>> map = new AtomicReference<>(); 

public void setMap(Map<String, String> map) {
    this.map.set(new HashMap<>(map));
}

public String getValue(String key) {
    Map<String, String> m = this.map.get();
    // loop is necessary if setMap(null) call occurs
    while (m == null) {
        // Use CAS to avoid possible overwrite of concurrent setMap() call
        m = new HashMap<>();
        if(!this.map.compareAndSet(null, m))
            m = this.map.get();
    }
    return m.get(key);
}