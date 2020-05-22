public static InputStream getInputStreamFromZip(File f, String fileEntry) {
    try {
        ZipFile zf = new ZipFile(f);
        Enumeration entries = zf.entries();
        while (entries.hasMoreElements()) {
            ZipEntry ze = (ZipEntry) entries.nextElement();
            System.out.println("Read " + ze.getName() + "?");
            if (ze.getName().equalsIgnoreCase(fileEntry)) {
                return zf.getInputStream(ze);
            }
        }
    } catch (IOException e) {
        System.err.println("io error accessing zip file");
    }
    return null;
}