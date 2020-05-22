PreparedStatement pstmt = conn.prepareStatement("select * from SELECT_SEARCH_DETAILS(?,?,?,?,?,?,?,?)");

pstmt.setString(1, abc.getContractNumber());
pstmt.setString(2, abc.getOrderNumber());
pstmt.setString(3, abc.getShipmentNumber());
pstmt.setString(4, abc.getShipmentControlNo());
pstmt.setString(5, abc.getStatusFromDate());
pstmt.setString(6, abc.getStatusToDate());
pstmt.setString(7, abc.getSourceSystem());
pstmt.setString(8, abc.getDestinationSystem());

ResultSet rs = pstmt.executeQuery();