public void updateFields(BorrowedBook borrowedBook) throws SQLException {
    PreparedStatement pstmt;
    try {
        Statement stmt = con.createStatement();
        pstmt = con.prepareStatement("UPDATE library_students.book SET CopiesInBorrow = CopiesInBorrow + 1, AvailableCopies = AvailableCopies - 1 WHERE BookID = ?");
        pstmt.setString(1, getBookID(borrowedBook));
        pstmt.executeUpdate();
        rs.close();
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
}