String productName = "Mockingjay"; // in stock
// String productName = "Baloon"; // out of stock
driver.get("http://www.gcrit.com/build3/admin");
login("admin", "admin@123");

selectCategory(productName);
boolean inStock = isProductInStock(productName);
System.out.println("Product is in stock: " + inStock);
if (inStock)
{
    editSelectedCategory();
    System.out.println("Changing the product status to 'Out of Stock'");
    // set the product to out of stock
}