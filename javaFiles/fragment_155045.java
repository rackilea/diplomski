private static class GenericFoo<T extends BaseClass>
{
    T createInstance(Class<T> clazz)
    {
        return clazz.newInstance();
    }
}