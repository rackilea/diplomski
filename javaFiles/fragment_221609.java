ByteArrayInputStream bais = null;
try {
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  workbook.write(baos);
  baos.flush();

  byte[] buffer = baos.toByteArray();

  bais = new ByteArrayInputStream(buffer);
  baos.close();
} catch (IOException e) {
  e.printStackTrace();
}
  return bais;