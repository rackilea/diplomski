public static class TC extends RichFlatMapFunction<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>> {
    private static TreeSet<Tuple2<Integer, Integer>> treeSet_duplicate_pair;
    private  static HashMap< Integer, Set<Integer>> clusters_duplicate_map;
    // either use a static initializer
    private  static  Stack<Tuple2< Integer,Integer>> stack = new Stack<Tuple2< Integer,Integer>>();
    public TC(List<Tuple2<Integer, Integer>> duplicatsPairs) {
        ...
    }

    @Override
    public void open(Configuration config) {
        // or initialize stack here, but here you have to synchronize the initialization
        ...
    }

    @Override
    public void flatMap(Tuple2<Integer, Integer> recordPair, Collector<Tuple2<Integer, Integer>> out) throws Exception {
        if (recordPair!= null)
        {
                    stack.push(recordPair);
        ...
        }
    }
}