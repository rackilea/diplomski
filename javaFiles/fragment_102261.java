class StockListApp {

private static Scanner scanner = new Scanner(System.in);

private static final int ADD_ITEM = 1;
private static final int DELETE_ITEM = 2;

private StockListApp() {}

public static void displayRootMenu() {
     System.out.println("StockList Main Menu");
     System.out.println("*******************");
     System.out.println("1. Add an Item");
     System.out.println("2. Delete an Item");
     System.out.println("3. Update Item Price");
     System.out.println("4. Update Item Quantity");
     System.out.println("5. Update ReOrder Level");
     System.out.println("6. Print Stock List");
     System.out.println("7. Print ReOrder List");
     System.out.println("8. Exit");

     System.out.println("Select option [1-8] :>");
     int choice = scanner.nextInt();
     displaySubMenu(choice);
}

private static void displayAddItemMenu() {
    // display menu and read next char from scanner.
}

private static void displayDeleteMenu() {
    // display menu and read next char from scanner.
}


private static void displaySubMenu(int option) {

    switch (option) {
      case StockListApp.ADD_ITEM: {
          displayAddItemMenu();
          break;
      }
      case StockListApp.DELETE_ITEM: {
          displayDeleteMenu();
          break;
      }
    }

}

}