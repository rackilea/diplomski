public class Inventory
{
    private static final int DEFAULT_INVENTORY_SIZE = 5;
    private Product [] products;
    private int numProducts;

    public Inventory()
    {
       this(DEFAULT_INVENTORY_SIZE);
    }

    public Inventory(int size)
    {
       products = new Product[size];
       numProducts = 0;
    }

    public void addProduct(Product p)
    {
       products[numProducts++] = p;

    }

    public void sort()
    {
        // sort the array here
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder(1024);

        // Create a string representation of you inventory here

        return builder.toString();
    } 
}