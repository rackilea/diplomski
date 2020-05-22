Connection con = ...;
try (PreparedStatement stmt = con.prepareStatement("select image from tableofimages")) {
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            try (InputStream is = rs.getBinaryStream(1)) {
                BufferedImage img = ImageIO.read(is);
            }
        }
    }
} catch (SQLException | IOException exp) {
    exp.printStackTrace();
}