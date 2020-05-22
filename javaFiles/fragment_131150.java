public Foo(String name)
{
    // Default the description to null
    this(name, null);
}

public Foo(String name, String description)
{
    this.name = name;
    this.description = description;
}