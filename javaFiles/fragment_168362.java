@ManagedBean
@ViewScoped
public ProductBean implements Serializable {
@ManagedProperty("#{productService}")
private ProductService productService;

public void setProductService(ProductService productService) {
    this.productService = productService;
  }
 }