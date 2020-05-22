// Here is the capture bufferedImage from your application
  BufferedImage screenShot = ...;

  // You create the zip file and you add entry that will store the image
  FileOutputStream fileOut = new FileOutputStream("yourZipFile.zip");
  ZipOutputStream zipOut = new ZipOutputStream(fileOut);
  zipOut.setLevel(9); // 9 is the max level      
  ZipEntry zipEntry = new ZipEntry("screenshot-2017-03-24_12-03-30.jpg");
  zipOut.putNextEntry(zipEntry);

  // you get the bytes from the image 
  ByteArrayOutputStream out = new ByteArrayOutputStream();
  javax.imageio.ImageIO.write(screenShot, "jpg", out);
  byte[] bytes = out.toByteArray();

  // you write the bytes in the zipOutputStream
  zipOut.write(bytes, 0, bytes.length);
  zipOut.close();