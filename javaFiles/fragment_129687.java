Optional<Product> product =
    customers.stream()
             .filter(c -> c.getProducts() != null && c.getProducts().getProduct() != null)
             .flatMap(c -> c.getProducts().getProduct().stream())
             .filter(p -> p.getId().equals(productId))
             .findFirst();