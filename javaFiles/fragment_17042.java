import static PojoValidator.validateFoo;
import static PojoValidator.validateBar;

class Pojo {
    private final String foo;
    private final Bar bar;

    public Pojo(final String foo, final Bar bar) {
        validateFoo(foo);
        validateBar(bar);
        this.foo = foo;
        this.bar = bar;
    }
}