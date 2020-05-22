public class ResultList {
    private int count;
    @JsonProperty("results") private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = Objects.requireNonNull(products, "products");
        this.count = products.size();
    }

    public int getCount() {
        return count;
    }
}