public class Foo {
    ...
    private Set<Bar> bars;
    ...
    public void addBar(Bar bar) {
        if (this.bars == null) {
            this.bars = new HashSet<Bar>();
        }
        this.bars.add(bar);
    }
}