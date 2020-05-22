interface Descriptor<O, J> {
    Ground<O, J> getGround();
}

public final class FooDescriptor<O, J> implements Descriptor<O, J> {
    @Override
    public FooGround<O, J> getGround() {
        ...
    }
}