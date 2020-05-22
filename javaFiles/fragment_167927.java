public static void main(String[] args) {
    System.out.print("product category: ");
    Scanner scanner = new Scanner(System.in);
    String product_category = scanner.nextLine();
    System.out.print("Inventory(press enter key for 999): ");
    String pi_string = scanner.nextLine();
    int product_inventory = pi_string.isEmpty()?
        999:Integer.parseInt(pi_string);
    scanner.close();
    System.out.println(String.format("%s, %d",
        product_category, product_inventory));
}