public interface ProductAccepter {
   public boolean accept(Product product);
}

public List<Product> searchItem(ListProduct list, ProductAccepter accepter) {
    List<Product> products = new ArrayList<Product>();
    for (Product prod : list.productList) {
        if (accepter.accept(prod))
            products.add(prod);
        }
    }
    return products;
}