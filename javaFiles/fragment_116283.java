class MapValueComparator implements Comparator<Map<String, Object>> {
        private final String key;

        public MapValueComparator(final String key) {
            this.key = key;
        }

        @Override
        public int compare(final Map<String, Object> o1, final Map<String, Object> o2) {
            return ((Comparable<Object>)o1.get(key)).compareTo(o2.get(key));
        }
    }

    Comparator<Object> nameThenCountComparator = ComparatorUtils.chainedComparator(
            new MapValueComparator("name"), 
            new MapValueComparator("count")
    );