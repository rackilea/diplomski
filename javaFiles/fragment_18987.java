public class Foo2BarConverter implements Function<Foo,Bar> {
    @Override
    public Bar apply(Foo f) {
       return new Bar(f.getBaz());
    }
}