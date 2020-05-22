Map<String, List<Integer>>  map = new HashMap<String, List<Integer>>(); 

    void storeValue(final String key, final Integer value) {
        List<Integer> l = this.map.get(key);
        if (l == null) {
            synchronized (this.map) {
                if (l == null) {
                    l = new Vector<Integer>();
                    this.map.put(key, l);
                }
            }
        }
        l.add(value);
    }

    List<Integer> searchByKey(final String key) {
        return this.map.get(key);
    }