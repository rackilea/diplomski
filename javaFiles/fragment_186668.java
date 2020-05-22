String cql =  "BEGIN BATCH "
       cql += "INSERT INTO test.prepared (id, col_1) VALUES (?,?); ";
       cql += "INSERT INTO test.prepared (id, col_1) VALUES (?,?); ";
       cql += "APPLY BATCH; "

DatastaxConnection.getInstance();
PreparedStatement prepStatement = DatastaxConnection.getSession().prepare(cql);
prepStatement.setConsistencyLevel(ConsistencyLevel.ONE);        

// this is where you need to be careful
// bind expects a comma separated list of values for all the params (?) above
// so for the above batch we need to supply 4 params:                     
BoundStatement query = prepStatement.bind(userId, "col1_val", userId_2, "col1_val_2");

DatastaxConnection.getSession().execute(query);