try (PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, searchString);
    ps.setString(2, searchString);
    ps.setString(3, searchString);
    ps.setString(4, searchString );

    try (ResultSet rs = ps.executeQuery()) {
        // read data 
    }
}