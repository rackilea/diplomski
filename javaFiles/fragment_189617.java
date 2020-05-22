String sql = "UPDATE BENEFICTOR SET ID = ?, FID = ?, .... WHERE ID = ?";

PreparedStatement stmt = connection.prepareStatement(sql);

stmt.setString( 1, T1.getText() );
stmt.setString( 2, T2.getText() );
...
stmt.setString( ?, T1.getText() );
stmt.executeUpdate();
stmt.close();