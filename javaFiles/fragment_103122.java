public static Product create(Product product,Shop shop) {      
    shop.products.add(product);
    product.shops.add(shop);
    product.save();
    return product;
}