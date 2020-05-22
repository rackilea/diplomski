ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
workbook.write(outputStream);
byte[] b = outputStream.toByteArray();
FileOutputStream fos = new FileOutputStream(tempFile);
IOUtils.write(b, fos);
return outputStream;