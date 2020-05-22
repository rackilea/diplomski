/**
 * Constructs a new, empty tree set, sorted according to the specified
 * comparator.  All elements inserted into the set must be <i>mutually
 * comparable</i> by the specified comparator: {@code comparator.compare(e1,
 * e2)} must not throw a {@code ClassCastException} for any elements
 * {@code e1} and {@code e2} in the set.  If the user attempts to add
 * an element to the set that violates this constraint, the
 * {@code add} call will throw a {@code ClassCastException}.
 *
 * @param comparator the comparator that will be used to order this set.
 *        If {@code null}, the {@linkplain Comparable natural
 *        ordering} of the elements will be used.
 */
public TreeSet(Comparator<? super E> comparator) {
    this(new TreeMap<E,Object>(comparator));
}