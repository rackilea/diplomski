public class FooUser {
    private Foo f;

    public void setFoo(Foo f) {
        this.f = f;
    }

    public Foo getFoo() {
        return f;
    }

    public void addToFoo(String string) {
        f.add(string);
    }
}