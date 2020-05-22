pstmnt = conn.createStatement();

pstmnt.executeQuery("DELETE FROM bd_vehicles_temp_1");
System.out.println("Query Executed");

conn.rollback();
System.out.println("Changes rolled back");