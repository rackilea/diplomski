preparedStmt.executeUpdate();
    ResultSet generatedKeyResult = preparedStmt.getGeneratedKeys();
//     preparedStmt.addBatch();
  //  preparedStmt.executeBatch();
    con1.commit();       
  }