@Root(name = "product")
public class Product
{
    @Path(value = "name")
    @Element(name = "language")
    private String name;

    @Path(value = "description")
    @Element(name = "language")
    private String description;

    @Path(value = "description_short")
    @Element(name = "language")
    private String desc;


    // ...

    /* For testing only */
    @Override
    public String toString()
    {
        return "Product{" + "name=" + name + ", description=" + description + ", desc=" + desc + '}';
    }
}