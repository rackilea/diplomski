public class IterableCollection<T> implements Collection<T>
{
   private final Iterable<T> iterable;

   public IterableCollection(Iterable<T> it) { this.iterable = it; }

   @Override public Iterator<T> iterator() { return iterable.iterator(); }

   @Override public int size() { return ... custom code to determine size ... }

   @Override .... all others ... { throw new UnsupportedOperationException(); }
}