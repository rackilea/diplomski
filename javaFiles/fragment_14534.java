public class A extends Checkable<A1Exception> {

    @Override
    protected A1Exception getException(int stuff) {
        return new A1Exception(stuff);
    }

    public void invokeStuff(int stuff) {
        doCheck(stuff);
    }

}