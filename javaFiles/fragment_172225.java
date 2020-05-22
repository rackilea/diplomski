JAXBElement jaxbElement1 = objectFactory.createRoot(rootType);
JAXBElement jaxbElement2 = objectFactory.createRoot(rootType);

ZipOutputStream zos = null; 
try {
  zos = new ZipOutputStream(new FileOutputStream("xml-file.zip"));
  // add zip-entry descriptor
  ZipEntry ze1 = new ZipEntry("xml-file-1.xml");
  zos.putNextEntry(ze1);
  // add zip-entry data
  marshaller.marshal(jaxbElement1, zos);
  ZipEntry ze2 = new ZipEntry("xml-file-2.xml");
  zos.putNextEntry(ze2);
  marshaller.marshal(jaxbElement2, zos);
  zos.flush();
} finally {
  if (zos != null) {
    zos.close();
  }
}