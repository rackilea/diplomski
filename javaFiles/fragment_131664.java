public final class Foo
{
    private final List<String> strings;

    public Foo(List<String> strings)
    {
        // Defensive copy on construction. Protects from constructing
        // code mutating the list.
        this.strings = new ArrayList<String>(strings);
    }

    public List<String> getStrings()
    {
        // Defensive copy on read. Protects from clients mutating the list.
        return new ArrayList<String>(strings);
    }
}