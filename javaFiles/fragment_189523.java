public class ObjectHolder<T> {
    private T m_object;

    public ObjectHolder( T object ) {
        m_object = object;
    }

    public T getValue() {
        return m_object;
    }

    public void setValue( T object ) {
        m_object = object;
    }
}