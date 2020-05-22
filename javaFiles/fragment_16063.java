while (resultSet.next()) {
  // String name = resultSet.getString(1);
  // String description = resultSet.getString(2);
  File image = new File("your path");
  FileOutputStream fos = new FileOutputStream(image);
  byte[] buffer = new byte[1];

  InputStream is = resultSet.getBinaryStream(3);
  while (is.read(buffer) > 0) {
    fos.write(buffer);
  }
  fos.close();
}