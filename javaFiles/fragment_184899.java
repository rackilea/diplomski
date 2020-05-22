java.sql.Date date = new java.sql.Date(SimpleDateFormat("dd/MM/yyyy").parse(d).getTime());

PreparedStatement stmt = db.conn.createPreparedStatement(); 
String sql = "INSERT INTO diag.current (COL1, COL2, COL3, COL4) VALUES(?, ?, ?, ?)";
PreparedStatement stmt = db.conn.createPreparedStatement();`
stmt.setString(1, col1);
stmt.setString(2, col2);
stmt.setDate(3, date);
stmt.setString(4, col4);
stmt.executeUpdate();
stmt.close();