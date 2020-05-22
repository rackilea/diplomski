public class SplittingStrategy {

        private static final int BATCH_SIZE = 500;
        private AtomicInteger counter = new AtomicInteger();

        public Collection<List<Pair<Integer, Set<Integer>>>> splitItems(Map<Integer, Set<Integer>> itemsByID) {
            List<Pair<Integer, Set<Integer>>> rawList = itemsByID.entrySet().stream()
                    .map((inspUA) -> new ImmutablePair<>(inspUA.getKey(), inspUA.getValue()))
                    .collect(Collectors.toList());

            return rawList.parallelStream()
                    .collect(Collectors.groupingBy(pair -> counter.getAndIncrement() / BATCH_SIZE)).values();
        }
    }