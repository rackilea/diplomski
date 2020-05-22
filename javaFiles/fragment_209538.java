BufferedImage bi = (BufferedImage)LImg.getImage();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(bi, type, baos);
byte[] dataToWrite = baos.toByteArray();
PreparedStatement stmt = con.prepareStatement("INSERT INTO CLIENT(ID, IMAGE) VALUES (1,?)");
stmt.setBlob(1, dataToWrite);
stmt.executeUpdate();