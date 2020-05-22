String query = "Select * From Withdraw where CustID = ? AND AccountNo = ?";
PreparedStatment preparedStatement = conn.prepareStatement(query);

preparedStatement.setString(1, aString);
preparedStatement.setString(2, anotherString);

rset = preparedStatement.executeQuery();