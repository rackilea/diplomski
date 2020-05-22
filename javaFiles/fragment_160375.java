res.setContentType("application/zip");
ZipOutputStream zout = new ZipOutputStream(res.getOutputStream());
ZipEntry parentEntry = new ZipEntry("parent.csv");
zout.putNextEntry(parentEntry);
while (... fetch entries ...)
    zout.write(...data...)
zout.closeEntry();