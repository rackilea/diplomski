for (Product product: products) {
    // Now you have the product. Just get the Id
    if (product.getId() == productId) {
        return product;
    }
}