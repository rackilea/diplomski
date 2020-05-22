/**
 * Returns a set backed by the specified map.  The resulting set displays
 * the same ordering, concurrency, and performance characteristics as the
 * backing map.  In essence, this factory method provides a {@link Set}
 * implementation corresponding to any {@link Map} implementation.  There
 * is no need to use this method on a {@link Map} implementation that
 * already has a corresponding {@link Set} implementation (such as {@link
 * HashMap} or {@link TreeMap}).
 *
 * <p>Each method invocation on the set returned by this method results in
 * exactly one method invocation on the backing map or its <tt>keySet</tt>
 * view, with one exception.  The <tt>addAll</tt> method is implemented
 * as a sequence of <tt>put</tt> invocations on the backing map.
 *
 * <p>The specified map must be empty at the time this method is invoked,
 * and should not be accessed directly after this method returns.  These
 * conditions are ensured if the map is created empty, passed directly
 * to this method, and no reference to the map is retained, as illustrated
 * in the following code fragment:
 * <pre>
 *    Set&lt;Object&gt; weakHashSet = Collections.newSetFromMap(
 *        new WeakHashMap&lt;Object, Boolean&gt;());
 * </pre>
 *
 * @param map the backing map
 * @return the set backed by the map
 * @throws IllegalArgumentException if <tt>map</tt> is not empty
 * @since 1.6
 */
public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
    return new SetFromMap<E>(map);
}

private static class SetFromMap<E> extends AbstractSet<E>
    implements Set<E>, Serializable
{
    private final Map<E, Boolean> m;  // The backing map
    private transient Set<E> s;       // Its keySet

    SetFromMap(Map<E, Boolean> map) {
        if (!map.isEmpty())
            throw new IllegalArgumentException("Map is non-empty");
        m = map;
        s = map.keySet();
    }

    public void clear()               {        m.clear(); }
    public int size()                 { return m.size(); }
    public boolean isEmpty()          { return m.isEmpty(); }
    public boolean contains(Object o) { return m.containsKey(o); }
    public boolean remove(Object o)   { return m.remove(o) != null; }
    public boolean add(E e) { return m.put(e, Boolean.TRUE) == null; }
    public Iterator<E> iterator()     { return s.iterator(); }
    public Object[] toArray()         { return s.toArray(); }
    public <T> T[] toArray(T[] a)     { return s.toArray(a); }
    public String toString()          { return s.toString(); }
    public int hashCode()             { return s.hashCode(); }
    public boolean equals(Object o)   { return o == this || s.equals(o); }
    public boolean containsAll(Collection<?> c) {return s.containsAll(c);}
    public boolean removeAll(Collection<?> c)   {return s.removeAll(c);}
    public boolean retainAll(Collection<?> c)   {return s.retainAll(c);}
// addAll is the only inherited implementation

    private static final long serialVersionUID = 2454657854757543876L;

    private void readObject(java.io.ObjectInputStream stream)
        throws IOException, ClassNotFoundException
    {
        stream.defaultReadObject();
        s = m.keySet();
    }
}