public class Set2ListTest {

    private static final int SMALL_SET_SIZE = 10;
    private static final int LARGE_SET_SIZE = 1000;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(Set2ListTest.class.getSimpleName())
                .forks(1)
                .threads(8)
                .warmupIterations(1)
                .measurementIterations(1)
                .build();
        new Runner(options).run();
    }

    @State(Scope.Benchmark)
    public static class Provider {

        Set<Set<Integer>> smallSet = new HashSet<>(SMALL_SET_SIZE);
        Set<Set<Integer>> largeSet = new HashSet<>(LARGE_SET_SIZE);

        @Setup
        public void setup() {
            fillSet(smallSet, SMALL_SET_SIZE);
            fillSet(largeSet, LARGE_SET_SIZE);
        }

        private void fillSet(Set<Set<Integer>> set, int count) {
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                Set<Integer> innerSet = new TreeSet<>();
                for (int j = 0; j < count; j++) {
                    innerSet.add(random.nextInt(Integer.MAX_VALUE));
                }
                set.add(innerSet);
            }
        }

    }

    @Benchmark
    public void small_plainJava(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(SMALL_SET_SIZE);
        for (Set<Integer> set : provider.smallSet) {
            list.add(new ArrayList<>(set));
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void large_plainJava(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(LARGE_SET_SIZE);
        for (Set<Integer> set : provider.largeSet) {
            list.add(new ArrayList<>(set));
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void small_guava(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(SMALL_SET_SIZE);
        for (Set<Integer> set : provider.smallSet) {
            list.add(com.google.common.collect.Lists.newArrayList(set));
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void large_guava(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(LARGE_SET_SIZE);
        for (Set<Integer> set : provider.largeSet) {
            list.add(com.google.common.collect.Lists.newArrayList(set));
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void small_commons(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(SMALL_SET_SIZE);
        for (Set<Integer> set : provider.smallSet) {
            List<Integer> innerList = new ArrayList<>(SMALL_SET_SIZE);
            CollectionUtils.addAll(innerList, set);
            list.add(innerList);
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void large_commons(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = new ArrayList<>(LARGE_SET_SIZE);
        for (Set<Integer> set : provider.largeSet) {
            List<Integer> innerList = new ArrayList<>(LARGE_SET_SIZE);
            CollectionUtils.addAll(innerList, set);
            list.add(innerList);
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void small_eclipse(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = FastList.newList();
        for (Set<Integer> set : provider.smallSet) {
            list.add(FastList.newList(set));
        }
        blackhole.consume(list);
    }

    @Benchmark
    public void large_eclipse(Provider provider, Blackhole blackhole) {
        List<List<Integer>> list = FastList.newList();
        for (Set<Integer> set : provider.largeSet) {
            list.add(FastList.newList(set));
        }
        blackhole.consume(list);
    }

}