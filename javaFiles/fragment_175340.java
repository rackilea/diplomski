ZipOutputStream zos = new ZipOutputStream(bos);
zos.putNextEntry(ze);
OutputStreamWriter writer = new OutputStreamWriter(zos, "UTF-8");
XMLWriter.writeXMLToWriter(rs,writer);
writer.close();
zos.closeEntry();
zos.flush();