public class IterablePile extends Pile implements Iterable<Thing> {
    //current class implementation...
    private class MyIterablePileIterator implements Iterator<Thing> {
        private Thing thing;
        private MyIterablePileIterator(Thing thing) {
            this.thing = thing;
        }
        @Override
        public boolean hasNext() {
            //add the implementation...
            return (thing.getLink1() != null || thing.getLink2() != null);
        }
        @Override
        public Thing next() {
            //add the implementation...
            //since it is a tree structure, you could use a Queue<Thing>
            //to implement prefix, infix or postfix navigation
        }
        @Override
        public void remove() {
            //add the implementation...
            //in case you don't want to implement it, you can leave it blank
            //or throw new UnsupportedOperationException("never remove!")
        }
    }
    @Override
    public Iterator<Thing> iterator() {
        return new MyIterablePileIterator(getAThing());
    }
}