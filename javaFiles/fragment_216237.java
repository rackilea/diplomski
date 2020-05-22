public class MyConcreteVisitor<X extends C> implements MyInterfaceVisitor<X, Class<X>> {

    @Override
    public X visitMyConcreteObject(MyConcreteObject object, Class<X> parameter) {
        // Do a lot of things.
        // Return an instance of the given class.
    }
}