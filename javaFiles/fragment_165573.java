String url = "jdbc:derby://localhost:1527/Cookbook";
try (Connection conn = DriverManager.getConnection(url)) {
    String query = "DELETE from RECIPES WHERE NAME = ?";
    try (PreparedStatement pst = conn.prepareStatement(query)) {
        pst.setString(1, name);
        int rowCount = pst.executeUpdate();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "'" + name + "' was not found");
        } else if (rowCount == 1) {
            JOptionPane.showMessageDialog(null, "'" + name + "' was successfully deleted");
        } else { // cannot happen if `NAME` has unique index in the database
            JOptionPane.showMessageDialog(null, rowCount + " recipes named '" + name + "' were deleted");
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "something went wrong: " + e);
}