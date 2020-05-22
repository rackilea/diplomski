private class ReadonlyProxyMap<K, V> implements Map<K, V> {

        private final List<Map<K, V>> maps = new ArrayList<>();

        public void addMap(Map<K, V> map) {
            maps.add(map);
        }

        @Override
        public int size() {
            return entrySet().size();
        }

        @Override
        public boolean isEmpty() {
            for (Map<K, V> map : maps) {
                if (!map.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean containsKey(Object key) {
            for (Map<K, V> map : maps) {
                if (map.containsKey(key)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            for (Map<K, V> map : maps) {
                if (map.containsValue(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public V get(Object key) {
            for (Map<K, V> map : maps) {
                if (map.containsKey(key)) {
                    return map.get(key);
                }
            }
            return null;
        }

        @Override
        public V put(K key, V value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Set<K> keySet() {
            Set<K> keySet = new HashSet<>();
            for (Map<K, V> map : maps) {
                keySet.addAll(map.keySet());
            }
            return keySet;
        }

        @Override
        public Collection<V> values() {
            List<V> values = new ArrayList<>();
            for (Map.Entry<K, V> entry : entrySet()) {
                values.add(entry.getValue());
            }
            return values;
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<K> keySet = new HashSet<>();
            Set<Map.Entry<K, V>> entrySet = new HashSet<>();
            for (Map<K, V> map : maps) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (!keySet.contains(entry.getKey())) {
                        entrySet.add(entry);
                        keySet.add(entry.getKey());
                    }
                }
            }
            return entrySet;
        }

    }