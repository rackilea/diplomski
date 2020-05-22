class LogLine<T extends Enum<T>>
{
    public void add(T item)
    {
        int numberOfElementsInEnum = item.getDeclaringClass().getEnumConstants().length;
    }
}