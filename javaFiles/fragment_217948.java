public abstract class Metric<T extends Foo> {

    public abstract  T precompute(); // valid syntax
    public abstract void distance(T arg); // valid syntax
    public class Foo {}

}