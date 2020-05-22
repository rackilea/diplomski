public class SortedByValueMap<K, V extends Comparable<V>> implements Comparator<K> {

    private final Map<K, V> map = new TreeMap<K, V>();

    private class CustomTreeMap<KK extends K, VV extends V> extends TreeMap<KK, VV> {

        private static final long serialVersionUID = 9196929305071517886L;

        private CustomTreeMap(Comparator<KK> c) {
            super(c);
        }

        @Override
        public VV put(KK key, VV value) {
            map.put(key, value);
            return super.put(key, value);
        };

        @Override
        public VV remove(Object key) {
            map.remove(key);
            return super.remove(key);
        }

    }

    @Override
    public int compare(K o1, K o2) {
        return map.get(o1).compareTo(map.get(o2));
    }

    public Map<K, V> getMap() {
        return new CustomTreeMap<K, V>(this);
    }

}