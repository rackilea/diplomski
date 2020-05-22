public class LimitIterator implements Iterator, Iterable {
   private it
   private limit
   private count

   LimitIterator(Iterator it, int limit) {
      limit = limit;
      count = 0;
      it = it
   }

   boolean hasNext(){
      return (count >= limit) ? false : it.hasNext()
   }

   Object next() {
      if (!hasNext()) throw new java.util.NoSuchElementException()

      count++
      return it.next()
   }

   Iterator iterator(){
      return this;
   }

   void remove(){
      throw new UnsupportedOperationException("remove() not supported")
   }

}

// Create a range from 1 to 10000
// and an empty list.
def list = 1..10000
def shortList = []

// Ensure that everything is as expected
assert list instanceof java.util.List
assert list.iterator() instanceof java.util.Iterator
assert list.size() == 10000
assert shortList instanceof java.util.List

// Grab the first 100 elements out of the lists iterator object.
for (i in new LimitIterator(list.iterator(), 100)) {
    shortlist.add(i);
}
assert shortlist.size() == 100