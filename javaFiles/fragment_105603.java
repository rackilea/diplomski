@ManagedBean
@ViewScoped
public class ProductManager {
    private List<Product> products;
    @PostConstruct
    public void init() { //you can change the method name
        //if you manually handle the controller, initialize it here
        //otherwise, let it be injected by EJB, Spring, CDI
        //or whichever framework you're working with
        products = controller.obtainProductList();
    }
    public List<Product> getProducts() {
        //plain getter, as simple as this
        //no business logic AT ALL
        return this.products;
    }
    public void filterProductsByCategory() {
        filtered = true;
        products = controller.obtainProductListByCategory(selectedDesiredCategory);
        //I guess this method logs a message or something...
        showMessage("Filtered by selected category");
    }
}