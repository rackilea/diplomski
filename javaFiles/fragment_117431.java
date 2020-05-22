sql = "delete from foo where ctid = ?";
deleteStmt = conn.prepareStatement( sql );
org.postgresql.util.PGobject pgo = new org.postgresql.util.PGobject();
pgo.setType("tid");
pgo.setValue("(0,54)");  // value is a string as might be returned in select ctid from foo and then resultSet.getString(1);
deleteStmt.setObject(1, pgo);

int a = deleteStmt.executeUpdate();
System.out.println("delete returns " + a);