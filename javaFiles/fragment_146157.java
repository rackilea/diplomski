String targetString = "بةرز";
try (PreparedStatement ps = conn.prepareStatement(
        "SELECT English FROM Table1 " +
        "WHERE Kurdish = ? " +
            "OR REGEXP_MATCHES(Kurdish, ?) " +
            "OR REGEXP_MATCHES(Kurdish, ?) " +
            "OR REGEXP_MATCHES(Kurdish, ?) ")) {
    ps.setString(1, targetString);
    ps.setString(2, "^" + targetString + "[.، ]+.*");
    ps.setString(3, ".*[.، ]+" + targetString + "$");
    ps.setString(4, ".*[.، ]+" + targetString + "[.، ]+.*");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}