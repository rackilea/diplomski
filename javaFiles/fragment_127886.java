public static void bookAll(String planeNo) {
    String sql = "UPDATE SEAT "
               + "SET (reserved, booked, booking_time) "
               + "VALUES ('1337', '1337', '1337') "
               + "WHERE plane_no=?";
    try (Connection conn = getConnection("", "");
         PreparedStatement st = conn.prepareStatement(sql)) {
        st.setString(1, planeNo);
        st.executeUpdate();
        conn.commit();
    } catch (SQLException ex) {
        System.out.println("[HELPER CLASS] SQL ERROR: " + ex.getMessage());
    }
}