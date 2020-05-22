public void addProductInCart(Product product, int quantity) {
    CartItem item = map.get(product.getId());
    if (item == null) {
        item = new CartItem(product, quantity);
        map.put(product.getId(), item);
    }
    else {
        item.addQuantity(quantity);
    }
}