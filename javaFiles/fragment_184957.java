List<Product> products = new ArrayList<Product>();
for (String s: prodList){
    Product p = new Product();
    p.setName(s);
    products.add(p);
}