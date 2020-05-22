public static InputStream get_dataImage() throws SQLException, IOException {
            InputStream in = null;
            Connection conn = Koneksi.getKoneksi();
            String sql = "SELECT*FROM setting";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Blob imageBlob = resultSet.getBlob("file_gambar");
                in = imageBlob.getBinaryStream();
            }
            return in;
        }