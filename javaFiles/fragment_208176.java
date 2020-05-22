public class IntFoo implements Foo<Integer> {

    @Override
    public Integer moo() { return mooAsInt(); }

    public int mooAsInt() { return 0; }
}