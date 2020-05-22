public static void main(String[] args)
{
    ArrayList<Product> productList = new ArrayList<Product>();
    productList.add(new Product(1, "Pen", 2.00, false));
    productList.add(new Product(2, "TV", 300, true));
    productList.add(new Product(3, "iPhone", 500, true));
    writeToCSV(productList);
}