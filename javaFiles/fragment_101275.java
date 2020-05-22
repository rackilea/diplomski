public class GenericOrder<T> {
    private static int ID = 0;
    private String serial;
    List<T> products;

    public GenericOrder() {
        serial = "CONTAINER_" + ID++;
        products = new ArrayList<T>();
    }

    public String getUniqueSerial() {
        return serial;
    }

    public void addProduct(T newProduct) {
        products.add(newProduct);
    }

    public int getNumberOfProducts() {
        return products.size();
    }
}