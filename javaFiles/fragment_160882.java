private static void demo(KVStore kvstore, String file2load) {
//Creating the table
String query;
try {
query = "CREATE TABLE Carros (plate STRING, brand STRING, owner STRING, km NUMBER, primary key (plate))";
    kvstore.executeSync(query);
} catch (IllegalArgumentException e) {
    System.out.println("Invalid statement:\n" + e.getMessage());
} catch (FaultException e) { //ATENTION HERE <-
    System.out.println("Statement couldn't be executed, please retry: " + e);
}
System.out.println("Table created");
//Fill up the table
populateTable(kvstore, file2load);
System.exit(0);
}