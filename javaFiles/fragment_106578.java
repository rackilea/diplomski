Statement s = dbConnection.createStatement(
        ResultSet.TYPE_FORWARD_ONLY, 
        ResultSet.CONCUR_READ_ONLY);
ResultSet rs = s.executeQuery("SELECT * FROM testdata");
rs.last();
System.out.println(String.format("Current row number: %d", rs.getRow()));
rs.previous();
System.out.println(String.format("Current row number: %d", rs.getRow()));