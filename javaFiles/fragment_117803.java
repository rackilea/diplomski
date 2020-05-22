ByteArrayOutputStream outputStream = null;
if(CollectionUtils.isNotEmpty(list returned from DB)) {
    outputStream = new ByteArrayOutputStream();
    ZipOutputStream zos = new ZipOutputStream(outputStream);
    //Add files to ZIP
    outputStream = new ByteArrayOutputStream();
    workbook.write(outputStream);
    zos.putNextEntry(new ZipEntry(xlsName.toString()));
    zos.write(outputStream.toByteArray());
    zos.flush();
    zos.close();
return outputStream;
}