public static void main(String[] args) {
    ArrayList<Product> product = new ArrayList<>();
    product.add(new Product(1, "pr1", 1));
    product.add(new Product(2, "pr2", 1));
    product.add(new Product(3, "pr3", 1.5));
    product.add(new Product(4, "pr4", 3));
    product.add(new Product(5, "pr5", 2));
    product.add(new Product(6, "pr6", 4));
    Price price = new Price();  // Custom comparator that compares two Products' price, must be defined elsewhere
    Collections.sort(product, price); 
    ArrayList<Product> longest = new ArrayList<>();
    for(int i=0; i < product.size(); i++) {
        if(budget - product.get(i).price > 0) {
            budget = budget - product.get(i).price;
            longest.add(product.get(i));
        }
    }
}