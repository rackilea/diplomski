public int orderProducts (List<Product> products) {
    int price = 0;
    for (Product prod : products) {
        price += prod.getPrice();
    }
    return price;
}