Connection conn = null;
PreparedStatement pst = null;
try {
    Class.forName("org.postgresql.Driver");
    conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/testdb", "postgres",
            "saurabh");
    conn.setAutoCommit(false);
    System.out.println("Opened database successfully");

    Scanner input = new Scanner(System.in);
    System.out.println("Enter the no.of records you want to enter");
    int n = input.nextInt();
    String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
            + "VALUES ( ?, ?, ?, ?, ? )";
    pst = conn.prepareStatement(sql);
    for (int i = 0; i < n; i++) {
        System.out.println("Enter id");
        int id = input.nextInt();
        pst.setInt(1, id);
        input.nextLine(); // <-- consume trailing newline.

        System.out.println("Enter name");
        String name = input.nextLine();
        pst.setString(2, name);
        System.out.println("Enter age");
        int age = input.nextInt();
        pst.setInt(3, age);
        input.nextLine(); // <-- consume trailing newline
        System.out.println("Enter Address");
        String address = input.nextLine();
        pst.setString(4, address);
        System.out.println("Enter Salary");
        double salary = input.nextDouble();
        pst.setDouble(5, salary);
        pst.addBatch();
    }
    pst.executeBatch();
    conn.commit();
} catch (Exception e) {
    System.err.println(e.getClass().getName() + ": " + e.getMessage());
    System.exit(0);
} finally {
    if (pst != null) {
        try {
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
System.out.println("Records created successfully");