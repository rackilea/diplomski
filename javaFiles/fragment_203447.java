public class SomeInterfaceImpl implements SomeInterface {
    @Override
    public boolean someDefaultMethod() {
        // this is the problem
        return SomeInterface.super.someDefaultMethod();
    }
}