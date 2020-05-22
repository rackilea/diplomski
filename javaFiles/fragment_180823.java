public boolean UserHasLatedReturn(int userID) throws NullPointerException {
    LocalDate todayDate = new LocalDate();
    LocalDate userBorrowDate = getUserBorrowDate(userID);
    if (userBorrowDate == null) {
        return false;
    }
    int difference = Days.daysBetween(userBorrowDate, todayDate).getDays();
    if (difference > 10) { // More than 10 days
        System.out.println("You have " + difference + " Days Delay in returning your previous book");
        return true;
    }
    return false;
}
public LocalDate getUserBorrowDate(int userID) {
    String query = "SELECT Borrow_Date FROM Borrowed WHERE User_ID=?";
    LocalDate date = null;
    try (Connection con = DriverManager.getConnection(dbUrl, "root", "2323");
            PreparedStatement ps = con.prepareStatement(query);) {
        ps.setInt(1, userID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            date = LocalDate.fromDateFields(rs.getDate("Borrow_Date"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return date;
}