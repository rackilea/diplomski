public class MyConcreteVisitor implements MyInterfaceVisitor<C, Class<? extends C>> {

    @Override
    public C visitMyConcreteObject(MyConcreteObject object, Class<? extends C> parameter) {
        // Do a lot of things.
        // Return an instance of the given class.
    }
}