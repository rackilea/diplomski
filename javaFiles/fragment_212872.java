public class EnumFactory<T extends Enum<T> & MyItems>
    implements MyItemsFactory<T>
{
    private final Class<T> clazz;

    public EnumFactory(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    public Iterable<T> values()
    {
        return EnumSet.allOf(clazz);
    }
}