byte[] imgData = null;
 if (rs.next ())
 {
   Blob img  = rs.getBlob(1);
   imgData = img.getBytes(1,(int)img.length());
   BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgData));
   yourJLabelInstance.setIcon(new ImageIcon(image));
 }