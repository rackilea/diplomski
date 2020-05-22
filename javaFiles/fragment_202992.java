abstract class Product
{
    ...
}

class OneProduct extends Product
{
    ...
    static
    {
        ProductFactory.instance().registerProduct("ID1", OneProduct::new);
    }
    ...
}

class ProductFactory
{
    Map<String,Supplier<Product>> m_RegisteredProducts = new HashMap<>();

    public void registerProduct(String productID, Supplier<Product> p)    {
        m_RegisteredProducts.put(productID, p);
    }

    public Product createProduct(String productID){
        // There should be a null check here...
        return m_RegisteredProducts.get(productID).get();
    }
}