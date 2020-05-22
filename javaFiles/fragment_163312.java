public static Connection createDatabaseConnection() throws SQLException, ClassNotFoundException {
    //...
    System.out.println("Database Connected...");
    try (Statement statement = c.createStatement()) {
        count = statement.executeUpdate("CREATE TABLE VAULT (Expenses VARCHAR(5000), ExpensesType VARCHAR(5000), PaymentType VARCHAR(5000), Amount VARCHAR(10), Date VARCHAR(5000))");
        System.out.println("Table Created...");
    }

    try (Statement statement = c.createStatement()) {
        ResultSet res = statement.executeQuery("SELECT * FROM VAULT");
        while (res.next()) {
            String[] row = {res.getString("Expenses"), res.getString("ExpensesType"), res.getString("PaymentType"), res.getString("Amount"), res.getString("Date")};
            System.out.print(res.getString("Expenses"));
            System.out.print(res.getString("ExpensesType"));
            System.out.print(res.getString("PaymentType"));
            System.out.print(res.getString("Amount"));
            System.out.print(res.getString("Date"));

            GUI.tableModel.addRow(row);
        }
    }