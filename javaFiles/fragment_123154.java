class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1: First", "2: Second", "3: Third", "4: Fourth");
        List<String> resultList = stringList.stream()
                .sorted()
                .filter(new WithPrevPredicate() {
                    @Override
                    public boolean test(String prev, String current) {
                        return current.contains("Second") && prev != null && prev.contains("First");
                    }
                })
                .collect(Collectors.toList());
        System.out.println(resultList);
    }

    private static abstract class WithPrevPredicate<T> implements Predicate<T> {
        private T prev = null;

        @Override
        public boolean test(T current) {
            boolean test = test(prev, current);
            prev = current;
            return test;
        }

        public abstract boolean test(T prev, T current);
    }
}