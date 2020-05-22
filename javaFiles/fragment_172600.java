@PostConstruct
public void init()
{
    productList = gnomeFacade.findAll();
}

public List<Gnome> getProductList()
{
    return productList;
}