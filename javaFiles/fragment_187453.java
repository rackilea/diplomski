ZipFile zipFile = new ZipFile("test.zip");
final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("out.zip"));
for(Enumeration e = zipFile.entries(); e.hasMoreElements(); ) {
    ZipEntry entryIn = (ZipEntry) e.nextElement();
    if (!entryIn.getName().equalsIgnoreCase("abc.txt")) {
        zos.putNextEntry(entryIn);
        InputStream is = zipFile.getInputStream(entryIn);
        byte[] buf = new byte[1024];
        int len;
        while((len = is.read(buf)) > 0) {            
            zos.write(buf, 0, len);
        }
    }
    else{
        zos.putNextEntry(new ZipEntry("abc.txt"));

        InputStream is = zipFile.getInputStream(entryIn);
        byte[] buf = new byte[1024];
        int len;
        while ((len = (is.read(buf))) > 0) {
            String s = new String(buf);
            if (s.contains("key1=value1")) {
                buf = s.replaceAll("key1=value1", "key1=val2").getBytes();
            }
            zos.write(buf, 0, (len < buf.length) ? len : buf.length);
        }
    }
    zos.closeEntry();
}
zos.close();