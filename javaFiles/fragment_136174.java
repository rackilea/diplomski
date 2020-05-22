// begin transaction
 connection.setAutoCommit(false);

 CallableStatement cs = connection.prepareCall(INSERT_STMT_INTO_ORDERS_TABLE);
 cs.registerOutParameter(1, Types.INT);
 int updateCount = cs.execute();
 // Check the update count.
 long orderNo = cs.getInt(1);

 // CallableStatement csLine for inserting into order_line table
 // for (OrderLine line: orderLines) {
 //     Set the orderNo in line.
 //     set paramters on csLine.
 //     csLine.addBatch();
 // }
 // run the batch and verify update counts
 connection.commit();

 // connection.rollback() on error.