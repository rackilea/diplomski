try (Connection con = DB.connect()) {
    try (PreparedStatement p = con.prepareStatement(
            "insert into documents values (?, ?, ?)")) {
        p.setString(1, jTextField3.getText());
        p.setString(2, jTextField2.getText());
        p.setString(3, jTextField1.getText());
        p.executeUpdate();
    }
} catch (SQLException e) {
    // handle exception...
}