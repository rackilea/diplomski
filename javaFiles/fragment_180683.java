sos = response.getOutputStream();
zos = new ZipOutputStream(sos);

// ...

while ((readBytesCount = fis.read(buffer)) >= 0) {
    sos.write(buffer, 0, readBytesCount); // <-- should be zos instead of sos
}