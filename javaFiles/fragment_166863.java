String updateQuery = ""
        + "UPDATE student "
        + "SET    firstname = ?, "
        + "       lastname = ?, "
        + "       gpa = ?, "
        + "       status = ?, "
        + "       mentor = ?, "
        + "       level = ?, "
        + "       theseistitle = ?, "
        + "       thesisadvisor = ?, "
        + "       company = ? "
        + "WHERE  studentid = ? ";

PreparedStatement pstmt = con.prepareStatement(updateQuery);
pstmt.setString(1,firstName)
pstmt.setString(2,lastName)
pstmt.setInt(3,gpa)
pstmt.setString(4,status)
pstmt.setString(5,mentor)
pstmt.setString(6,level)
pstmt.setString(7,thesisTitle)
pstmt.setString(8,thesisAdvisor)
pstmt.setString(9,company)
pstmt.setString(10,studentID)