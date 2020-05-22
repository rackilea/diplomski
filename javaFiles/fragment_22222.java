public static class MultiMap<V> {

        public static class MultiMapIndex<K,V> extends AbstractMap<K,V> {
            @Override
            public Set<Entry<K, V>> entrySet() {
                return map.entrySet();
            }
            HashMap<K,V> map = new HashMap<>();
       }


        public <K> MultiMapIndex<K,V> addIndex(Function<V, K> f) {
            MultiMapIndex<K,V> result = new MultiMapIndex<>();
            Consumer<V> e = (V v) -> result.map.put(f.apply(v), v);
            mappers.add(e);
            values.forEach(e);
            return result;
        }

        public <K> MultiMapIndex<K,List<V>> addMultiIndex(Function<V, K> f) {
            MultiMapIndex<K,List<V>> result = new MultiMapIndex<>();
            Consumer<V> e = (V v) -> {
                K key = f.apply(v);
                List<V> list = result.map.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    result.map.put(key, list);
                }
                list.add(v);
            };
            mappers.add(e);
            values.forEach(e);
            return result;
        }

        public void add(V v) {
            values.add(v);
            mappers.forEach( e -> e.accept(v));
        }

        private List<Consumer<V>> mappers = new ArrayList<>();
        private List<V> values = new ArrayList<>();    
    }