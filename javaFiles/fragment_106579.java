Statement s = dbConnection.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, 
        ResultSet.CONCUR_READ_ONLY);
s.setFetchSize(Integer.MIN_VALUE);
ResultSet rs = s.executeQuery("SELECT * FROM testdata");
rs.next();
System.out.println("Data from first row: " + rs.getString(2));
System.out.println("now let's try rs.last() ...");
try {
    rs.last();
    System.out.println("... Okay, done.");
} catch (Exception e) {
    System.out.println("... Exception: " + e.getMessage());
}