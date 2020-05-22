public class MetricDefault extends Metric<Bar> {

    @Override
    public Bar precompute() { return new Bar(); } 

    @Override
    public void distance(Bar arg){} 

    public class Bar extends Foo {}

}