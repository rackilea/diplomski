public class Foo {
    private Collection<Bar> bars = new ArrayList<Bar>();

    // immutable property - can only be read once this object is instantiated
    public Collection<Bar> getBars() {
        return this.bars;
    }

    public void addBar(Bar bar) {
        this.bars.add(bar);
    }

    public int getBarCount() {
        return this.bars.size();
    }
}

Foo foo = new Foo();
foo.getBars().add(new Bar(someUnexpectedBar));
System.out.println(foo.getBarCount());  // -> 1