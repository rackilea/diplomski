public final class Memento<T>
{
    // List of saved values
    private final Queue<T> queue = new ArrayDeque<T>();

    // Last entered value, whether it has been saved or not
    private T currentValue;

    // No initial state, ie currentValue will be null on construction, hence
    // no constructor

    // Set a value, don't save it
    public void set(final T value)
    {
        currentValue = value;
    }

    // Persist the currently saved value
    public void persist()
    {
        queue.add(currentValue);
    }

    // Return the last saved value
    public T lastSaved()
    {
        return queue.element();
    }

    // Return the last entered value
    public T lastEntered()
    {
        return currentValue;
    }
}