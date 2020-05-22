byte[] data;
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bos);
try {
  oos.writeObject(DATA);
  data = bos.toByteArray();
} finally {
  oos.close();
}    

PreparedStatement pstmt = jdbcConnection.prepareStatement(
    "insert into MYTABLE (id, data) values (?, ?)");
pstmt.setLong(1);
pstmt.setBlob(2, new ByteArrayInputStream(data));

...