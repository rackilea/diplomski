void substitute(ZipInputStream zis, ZipOutputStream zos) {
  for (ZipEntry ze = zis.getNextEntry(); ze != null; ze = zis.getNextEntry()) {
    if (ze.getName() is what you want to copy) {
      zos.putNextEntry(ze)
      Array[Byte] buffer = new Array[Byte](1024)
      for (int read = zis.read(buffer); read != -1; read = zis.read(buffer)) {
        zos.write(buffer, 0, read)
      }
      zos.closeEntry
    }
  }
  zos.close()
  zis.close()
}