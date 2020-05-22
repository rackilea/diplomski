String phonenumber = cust.getPhoneNumber();
Statement s = connection.createStatement();
ResultSet results = s.executeQuery("SELECT phonenumber, numberoforders FROM customer WHERE phonenumber = " + phonenumber);
results.next();
try {
    if (results.getString(1).equals(phonenumber)) {
        System.out.println("User already exist in database, adding one to order count");
        int updated = results.getInt(2) + 1;
        System.out.println(updated);

        PreparedStatement updateCust = connection.prepareStatement("UPDATE customer SET numberoforders = ? WHERE phonenumber = ?");
        updateCust.setInt(1, updated);
        updateCust.setString(2, phonenumber);
        updateCust.executeUpdate();
    }
} catch (SQLException sql) {
    sql.printStackTrace();
    try {
        PreparedStatement prepCust = connection.prepareStatement("insert into Customer values (?, ?, ?, ?, ?, ?);");
        prepCust.setString(1, cust.getfName());
        prepCust.setString(2, cust.getlName());
        prepCust.setString(3, cust.getAddress());
        prepCust.setString(4, cust.getPhoneNumber());
        prepCust.setInt(5, 1);
        prepCust.setInt(6, 0);
        prepCust.executeUpdate();
    } catch (SQLException sql2) {
        sql2.printStackTrace();
    }
}