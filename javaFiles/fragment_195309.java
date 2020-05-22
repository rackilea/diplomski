public class FooBarComparator implements AttributeComparator<Foo> {

    public int compare(Foo foo1, Foo foo2) {
        // skipped nullchecks for brevity
        return foo1.getBar().compare(foo2.getBar());
    }

    public String getSortingAttribute() {
        return "bar";
    }