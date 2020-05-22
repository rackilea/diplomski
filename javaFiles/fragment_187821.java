// pseudocode
   connection = getConnection();
   connection.setautoCommit(false);
   r = getRecord(connection);
   r = processRecord(r);
   writeRecord(r,connection);
   connection.commit();