public class Foo {
    private Collection<Bar> bars = new LinkedList<Bar>();
    private int barCount;  // for faster inserts, use a linked list and to maintain fast counts, track the count ourselves by tracking the adds.

    // immutable property - can only be read once this object is instantiated
    public Collection<Bar> getBars() {
        return this.bars;
    }

    public void addBar(Bar bar) {
        this.bars.add(bar);
        this.barCount++;
    }

    public int getBarCount() {
        return this.barCount;
    }
}

Foo foo = new Foo();
foo.getBars().add(new Bar(someUnexpectedBar));
System.out.println(foo.getBarCount());  // -> 0