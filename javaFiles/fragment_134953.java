try (
    ResultSet cRset = cStmt.executeQuery(cQuery);
    PreparedStatement aStmt = aConn.prepareStatement(aQuery);
) {
    while (cRset.next()) {
        //stuff to determine value of parm1

        aStmt.setString(1, parm1);                
        try (ResultSet aRset = aStmt.executeQuery()) {
            //more stuff
        }
    }
}