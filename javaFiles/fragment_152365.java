public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
    Connection conn=DBConnection.getDBConnection().getConnection();
    Statement stm;
    stm = conn.createStatement();
    String sql = "Select * From Customer";
    ResultSet rst;
    rst = stm.executeQuery(sql);
    ArrayList<Customer> customerList = new ArrayList<>();
    while (rst.next()) {
        Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
        customerList.add(customer);
    }
    return customerList;
}