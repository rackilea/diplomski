public class CustomerViewQuery {

   public List<Customer> list(String name) throws SQLException {

    List<Customer> customers = new ArrayList<Customer>();
     //get connection like this
    try(Connection con = DBConnection.dbconnect()) {

        PreparedStatement pst = con.prepareStatement("SELECT * FROM customers WHERE username=?;");
        pst.setString(1, name); //set name like this (The '1' means first occurance of a question mark '?')
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            customer.setAddress(resultSet.getString("address"));
            customer.setSex(resultSet.getString("sex"));
            customer.setBday(resultSet.getString("bday"));
            customer.setTelephone(resultSet.getString("telephone"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));
            customers.add(customer);
        }
    }catch(SQLException e) {
        e.printStackTrace();
    }

    return customers;
   }

}