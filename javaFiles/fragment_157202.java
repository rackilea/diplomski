@Entity
public class Region {

    // ... some codes here
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> ProductEntities;

    @Transient
    private HashMap<Long, List<Product>> productsMap;

    public HashMap<Long, List<Product>> getProductsMap() {
        if (ProductEntities!= null) {
            for (Product product : ProductEntities) {
                List<Product> productList = productsMap.get(product.getProductTypeEntity().getId());
                if (productList == null) {
                    productList= new ArrayList<Product>();
                }
                productList.add(product);
                productsMap.put(product.getProductTypeEntity().getId(), productList);
            }
        }
        return productsMap;
    }

    // ... rest of codes
}