Product chosenProduct = productMap.get(choice);
System.out.println("You chose " + chosenProduct.getName() + "!");
if (money < chosenProduct.getPrice()) {
    System.out.println("This is not enough money to buy this product");
} else {
    System.out.println(" Price = " + chosenProduct.getPrice() + "  Your change = " + (money - chosenProduct.getPrice()));
}