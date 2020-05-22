private Connection con = null;
private Statement stmt = null;
private ResultSet rs = null;

con = ConnectionManager.getConnection();
stmt = con.createStatement();
rs = stmt.executeQuery(sql);