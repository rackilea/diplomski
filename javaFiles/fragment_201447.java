String updateTableSQL = "UPDATE department  SET agentID = ?"
PreparedStatement preparedStatement = 
       dbConnection.prepareStatement(updateTableSQL);
preparedStatement.setInt(1, id);

// execute update SQL stetement
preparedStatement.executeUpdate();