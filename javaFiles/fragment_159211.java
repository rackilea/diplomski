@ManagedBean(name="productsBean")
@RequestScoped
public class ProductsBean implements Serializable {

private List <Product> products;

@ManagedProperty(value="#{applicationBean}")
private applicationBean appBean;

public ProductsBean(){

}

}