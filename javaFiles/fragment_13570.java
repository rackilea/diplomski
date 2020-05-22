ResultSet resultSet = connection.query("select url_image from "+name+" where id = "+List.get(i));
                    java.sql.Blob blob = null;

                    try {
                        while (resultSet.next()) {
                            blob = resultSet.getBlob("url_image");
                        }
                    } catch (SQLException e4) {
                        e4.printStackTrace();
                    }
                    BufferedImage destImage = null;
                    try {
                        destImage = ImageIO.read(blob.getBinaryStream());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    //Image scaledImage = destImage.getScaledInstance(photoLabel.getWidth(),photoLabel.getHeight(), Image.SCALE_DEFAULT); // error
                    //ImageIcon imgIc = new ImageIcon(scaledImage);
                    //photoLabel.setIcon(imgIc);
                    photoLabel.setIcon(new ImageIcon(destImage ));


     photoLabel = new javax.swing.JLabel();
     .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addComponent(photoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    private javax.swing.JLabel photoLabel;