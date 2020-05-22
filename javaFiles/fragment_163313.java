String updateStatement = "INSERT INTO VAULT"
                + " (Expenses, ExpensesType, PaymentType, Amount, Date)"
                + " VALUES (\'" + expenses + "\',\'" + expensesType + "\',\'" + paymentType + "\',\'" + amount + "\',\'" + date + "\')";
try (Statement statement = c.createStatement()) {
    System.out.print(updateStatement);
    int c = statement.executeUpdate(updateStatement);
    count = count + c;

    System.out.println("Data Inserted in to Database...");
} catch (Exception ex) {
    ex.printStackTrace();
}