public String getTemplateText(String name) {
    try (Connection conn = getConnection();
            PreparedStatement stmt = conn
                    .prepareStatement("SELECT templateText FROM TEMPLATE WHERE " + 
                    "templateTag = ?")) {
        stmt.setString(1, name);
        try (ResultSet rs = stmt.executeQuery()) {
            System.out.println("Set Text...");
            String tempText = rs.getString("templateText");
            return tempText;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "";
}