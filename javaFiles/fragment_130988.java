@Root(name = "prestashop")
public class Prestashop
{
    @ElementList(name = "products", empty = false, required = true)
    private ArrayList<Product> products;


    public Prestashop()
    {
        this.products = new ArrayList<>();
    }


    /* Some list methods */

    public void add(Product p)
    {
        products.add(p);
    }

    public Product get(int index)
    {
        return products.get(index);
    }

    public Product first()
    {
        return products.get(0);
    }

}