public class Shop { 
    @Produces @ApplicationScoped 
    @Catalog @Named("catalog") 
    private List<Product> products = new LinkedList<Product>(8);

    //...
}

public class OrderProcessor {
    @Inject
    @Catalog
    private List<Product> products;
}