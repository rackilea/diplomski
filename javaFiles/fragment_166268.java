public interface A
{
    List getList();

    // this is still only an interface, but you have a default impl. here
    default void add(Object o)
    {
        getList().add(o);
    }
}