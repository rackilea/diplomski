public class Foo<T extends Moo<Long>> {
    private static Foo<?> foo = new Foo<MooImpl>(new Bar<MooImpl>());

    private Bar<T> bar;

    public Foo(Bar<T> bar) {
        this.bar = bar;
    }

    public void barfoo(List<? extends Moo<Long>> list) {
        System.out.println(list);
    }

    public void foobar(T t) {
        System.out.println(t.getValue());
    }

    public void other() {
        List<? extends Moo<Long>> somelist = null;
        foo.barfoo(somelist);
    }
}