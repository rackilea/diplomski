sql = "insert into accounts "
    + " (UserEmail, UserPassword)" + " values (?, ?)";
Statement myStmt = myConn.prepareStatement(sql);
myStmt.setString (1, email);
myStmt.setString (2, password);

myStmt.executeUpdate ();