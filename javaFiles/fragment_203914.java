@Root(name = "example")
public static class ListExample
{
    @ElementList(name = "Shops", inline = true)
    private List<Shop> shops;

    // ...
}