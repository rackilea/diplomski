query =
"UPDATE customer"
+ " SET customer.cust_ID=?, customer.sale_ID=? ...";

PreparedStatement statement = conn.prepareStatement(query);
statement.setString(1, custID);
statement.setString(2, saleID);
statement.executeUpdate();