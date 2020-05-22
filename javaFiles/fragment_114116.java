public static void main(String[] args) 
{
    ArrayList<ShoppingItem> shoppingList = new ArrayList<ShoppingItem>();

    System.out.println("You can add seven items to purchase when prompted ");
    for (int i = 0; i <7; i++) {
        ShoppingItem item = new ShoppingItem(); //shopping item objects created
        System.out.println("Enter data for the shopping item " + i);
        item.readInput();
        shoppingList.add(item);
        System.out.println();
    }
}