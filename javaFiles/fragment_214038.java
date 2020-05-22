While(rs.next())
{
    pName = rs.getString("productName");
    System.out.println("Product: " + pName);

    // MATA IN ANTAL
    System.out.println("\nEnter amount:");
    GroceryStore.amount = GroceryStore.scan.nextInt();


    pPrice = rs.getDouble("productPrice");
}