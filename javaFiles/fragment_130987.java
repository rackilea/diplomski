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

    @Element(name = "id_default_image")
    private AttributedElement idDefaultImage;

    @Element(name = "price")
    private double price;

    @Element(name = "id")
    private int id;



    @Override
    public String toString()
    {
        return "Product{" + "name=" + name + ", description=" + description 
                + ", desc=" + desc + ", idDefaultImage=" + idDefaultImage 
                + ", price=" + price + ", id=" + id + '}';
    }



    @Root(name = "AttributedElement")
    static class AttributedElement
    {
        @Attribute(name = "href")
        private String value;


        public AttributedElement(String value)
        {
            this.value = value;
        }

        private AttributedElement()
        {
            /* Empty constructor required here */
        }


        @Override
        public String toString()
        {
            return value;
        }
    }

}