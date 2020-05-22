PreparedStatement pstmt1 = con.prepareStatement(
    "SELECT * FROM WorkOrder WHERE WorkOrderID = ?");
PreparedStatement pstmt2 = con.prepareStatement(
    "SELECT * FROM Customer WHERE CustID = ?");
PreparedStatement pstmt3 = con.prepareStatement(
    "SELECT * FROM Quote WHERE QuoteID = ?");

pstmt1.setInt(1, workOrderId)
ResultSet rset1 = pstmt1.executeQuery();

// test validity of rset1 
if(rset1.next()) {
    pstmt2.setInt(1, rset1.getInt(3))
    ResultSet rset2 = pstmt2.executeQuery();

    // test validity of rset2
    if(rset2.next()) {
        pstmt3.setInt(1, rset1.getInt(2))
        ResultSet rset3 = pstmt3.executeQuery();
    }
}