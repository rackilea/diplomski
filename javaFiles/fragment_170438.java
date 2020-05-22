public void uploadPubList(PubList pubList){
    String sql = "INSERT OR REPLACE INTO main.PubLists(Town,PostCodeArea,NumberOfPubs) VALUES(?,?,?)";
    try {
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, pubList.getName());
        pstmt.setString(2, pubList.getPostCodeArea());
        pstmt.setInt(3, pubList.getPubs().size());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}