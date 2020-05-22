public static void main(String[] args) {
    // Print the property of the RetailItem *class*: remember, you don't even have an instance of the class at this point.
    System.out.println(RetailItem.itemName); // null

    RetailItem item = new RetailItem("a", 1, 1);

    // Print the property of the class again, ignoring the instance that you created.
    System.out.println(RetailItem.itemName); // "a"
}