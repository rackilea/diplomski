String sqlQ = "INSERT INTO [dbo].[Transaction]([TransactionID],[ProductID],[TotalPrice]) VALUES (?,?,?) ";
PreparedStatement sqlstatement = dbconbt8.prepareStatement(sqlQ);
sqlstatement.setInt(1, count);
sqlstatement.setString(2, table_1.getValueAt(count, 0).toString());
sqlstatement.setInt(3, sumprice);
sqlstatement.executeUpdate();