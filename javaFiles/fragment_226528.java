public class TestIt {

    public static class ListWrapper<K> {
        private List<K> list = new ArrayList<>();

        public synchronized void add(K value) {
            list.add(value);
        }

        public synchronized void executeOperation(Operation<K> operation) {
            for (K k: list) {
                operation.execute(k);
            }
        }

    }

    public static interface Operation<K> {
        void execute(K value);
    }

    public static void main(String[] args) {
        ListWrapper<String> strings = new ListWrapper<>();
        strings.add("FOO");
        strings.add("BAR");
        strings.executeOperation(new Operation<String>() {
            @Override
            public void execute(String value) {
                System.out.println(value);
            }
        });

    }

}