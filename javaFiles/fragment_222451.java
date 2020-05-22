public class Foo {
   Iterator<Integer> iterator;

   public boolean hasNext() { return iterator.hasNext(); }
   public Integer next() { return iterator.next(); }
   public void remove() { iterator.remove(); }
}