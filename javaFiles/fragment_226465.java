Connection con = ...;
BufferedImage img = ...;
try (PreparedStatement stmt = con.prepareStatement("insert into tableofimages (image) values (?)")) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        ImageIO.write(img, "png", baos);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {
            stmt.setBinaryStream(1, bais);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " rows updated");
        }
    }
} catch (SQLException | IOException exp) {
    exp.printStackTrace();
}