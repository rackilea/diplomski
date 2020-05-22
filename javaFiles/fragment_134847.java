PreparedStatement stmtUpdate = null;

String strUpdate = "update ShopSystem.Grocery set g_name= ? where g_id = ?";

stmtUpdate = yourconnection.prepareStatement(strUpdate);
stmtUpdate.setString(1,g_name);
stmtUpdate.setInt(2,g_id);
stmtUpdate.executeUpdate();