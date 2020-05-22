Map<Integer, Product> productById = new HashMap<>();
for (Product product : products)
    productById.put(product.getId(), product);

List<SoldProduct> soldProducts = new ArrayList<>();
for (ProductCartDTO productCartDTO : dto.getProducts()) {
    Product product = productById.get(productCartDTO.getIdProduct());
    if (product != null) {
        soldProducts.add(new SoldProduct(product, productCartDTO.getSerialList()));
    }
}