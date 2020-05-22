class BasicPointOperator extends Operator<BasicPoint<Integer, Integer>> {

    @Override
    Collector<BasicPoint<Integer, Integer>> operate(Collector<BasicPoint<Integer, Integer>> collector) {
        collector.collect(new BasicPoint<Integer, Integer>(1,2));
        return collector;
    }
}