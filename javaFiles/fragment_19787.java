public class CustomerViewQuery {


   public Customer getCustomer(String name) throws SQLException {

   Customer customer = new Customer();

    try(Connection con = DBConnection.dbconnect()) {

        PreparedStatement pst = con.prepareStatement("SELECT * FROM customers WHERE username=?;");
        pst.setString(1, name); //set name like this (The '1' means first occurance of a question mark '?')
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {

            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setEmail(resultSet.getString("email"));
            customer.setAddress(resultSet.getString("address"));
            customer.setSex(resultSet.getString("sex"));
            customer.setBday(resultSet.getString("bday"));
            customer.setTelephone(resultSet.getString("telephone"));
            customer.setUsername(resultSet.getString("username"));
            customer.setPassword(resultSet.getString("password"));

        }
    }catch(SQLException e) {
        e.printStackTrace();
    }

    return customer;
   }

}