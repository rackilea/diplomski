public class SomeOtherClass<A>{
    private Foo<A> x;
    public SomeOtherClass() {
        //create anonymous extension of the abstract outer class
        //for a real abstract class this would mean you have to
        //implement all methods which are declared abstract
        x = new Foo<A>(){};
        x = x.new Bar<A>();
    }
}