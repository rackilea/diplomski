public abstract class ContainAll<T extends All>
{
    private final List<T> list = new LinkedList<T>();

    // ...

    // FINAL! Subclasses cannot override it
    public final void addElement(final T element)
    {
        list.add(element);
    }
}