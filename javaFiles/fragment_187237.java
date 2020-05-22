String updateString = "UPDATE accounts SET inventory = ? WHERE userName = ? AND password = ?";
PreparedStatement updateStmt = con.prepareStatement(updateString);
updateStmt.setString(1, Inventory.inventory);
updateStmt.setString(2, Frame.username);
updateStmt.setString(3, Frame.password);
updateStmt.executeUpdate();