public static BufferedImage getImageBytes(int id) {
    BufferedImage image =null;
    byte[] imgData = null;
    try {

        String query = "exec [dbo].[sp_ObtenerImagen] '" + id + "'";
        Statement state = Constant.Conecctions().createStatement();
        ResultSet rs = state.executeQuery(query);
        while (rs.next()) {
            //is = rs.getBinaryStream(1);
            Blob img = rs.getBlob(1);
            imgData = img.getBytes(1, (int) img.length());
            try {
                image = ImageIO.read(new ByteArrayInputStream(imgData));
                //yourJLabelInstance.setIcon(new ImageIcon(image));
            } catch (IOException ex) {
                Logger.getLogger(D_Clientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return OperacionImagen.resize(image, 200, 200);
}