class PointOperator extends Operator<Point> {

    @Override
    Collector<Point> operate(Collector<Point> collector) {
        collector.collect(new BasicPoint<Integer, Integer>(1,2));
        return collector;
    }
}