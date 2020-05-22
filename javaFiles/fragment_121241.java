int value = stocks - Integer.parseInt( quantPos.getText() );

String sql = "UPDATE Goods SET Stocks = ? WHERE ID = ?";

PreparedStatement stmt = connection.prepareStatement(sql);
stmt.setString( 1, value );
stmt.setString( 2, theIdHere );
stmt.executeUpdate();