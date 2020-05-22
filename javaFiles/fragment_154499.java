try (PreparedStatement stmt = conn.prepareStatement(sql);
     ResultSet rs = stmt.executeQuery()) {
    while (rs.next()) {
        System.out.println(rs.getString("email"));
        System.out.println(rs.getString("password"));
    }
}