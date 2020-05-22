public List<Product> getProductByCategory(String category) {

    if(products.size() == 0){
        return new ArrayList<>();
    }

    return this.products.values().stream()
       .filter(product -> product.getCategory().equals(category))
       .collect(Collectors.toList());
}