public class MySortedSet<E> ... {
    private Comparator<? super E> _comparator;

    public int innerCompare(E e1, E e2)
    {
      if (_comparator != null)
        return _comparator.compare(e1,e2);
      else
        return e1.compareTo(e2);
    }

    ...