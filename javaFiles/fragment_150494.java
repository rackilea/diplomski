public class SomeBean implements Comparable<SomeBean>{

    private String foo;
    private int bar;
    private List<String> baz;

    public int compareTo(SomeBean other) {
        return new CompareToBuilder()
        .append(foo, other.foo)
        .append(bar, other.bar)
        .append(baz, other.baz)
        .toComparison();
    }

}