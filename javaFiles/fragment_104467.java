/**
 * Appends all of the elements in the specified Collection to the end of
 * this Vector, in the order that they are returned by the specified
 * Collection's Iterator.  The behavior of this operation is undefined if
 * the specified Collection is modified while the operation is in progress.
 * (This implies that the behavior of this call is undefined if the
 * specified Collection is this Vector, and this Vector is nonempty.)
 */
public synchronized boolean addAll(Collection<? extends E> c) {
    modCount++;
    Object[] a = c.toArray();
    int numNew = a.length;
    ensureCapacityHelper(elementCount + numNew);
    System.arraycopy(a, 0, elementData, elementCount, numNew);
    elementCount += numNew;
    return numNew != 0;
}