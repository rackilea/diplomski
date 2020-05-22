String sql1 = "..."
try (PreparedStatement pst1 = con.prepareStatement(sql1)) {

    for (int a = 0; a < 100; ++a) {
        pst1.setInt(1, a);
        try (ResultSet rs1 = pst1.executeQuery()) {
            while (rs1.next()) {
            }
        } // Safe close of rs1
    }

} // Safe close of pst1