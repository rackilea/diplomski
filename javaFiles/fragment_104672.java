try (OutputStream os = ec.getResponseOutputStream();
    ZipOutputStream zout = new ZipOutputStream(os)) {
  zout.putNextEntry(new ZipEntry("foo.xls"));
  generate(zout, "Excell gen call args");
  zout.closeEntry();
  zout.putNextEntry(new ZipEntry("foo.csv"));
  generate(zout, "CSV gen call args");
  zout.closeEntry();
}