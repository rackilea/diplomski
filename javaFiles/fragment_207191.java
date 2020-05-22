private static void sortUsingKeyValueClass(Map<String, Integer> map) {
    class KeyValue implements Comparable<KeyValue> {
        private final Integer count;
        private final String word;

        public KeyValue(Integer count, String word) {
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo(KeyValue o) {
            return count.compareTo(o.count);
        }

        @Override
        public String toString() {
            return word + "=" + count;
        }
    }

    List<KeyValue> keyValues = new ArrayList<KeyValue>();
    for (String word : map.keySet()) {
        keyValues.add(new KeyValue(map.get(word), word));
    }
    Collections.sort(keyValues);
    System.out.println(keyValues);
}
--> output: [one=1, two=2, three=3]