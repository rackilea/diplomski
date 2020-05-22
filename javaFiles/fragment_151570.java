public static void unprotectXLSXSheet(String fileName, String password) throws Exception {
    InputStream is = null;
    FileOutputStream fileOut = null;

    try {
        is = new FileInputStream(fileName);
        if (!is.markSupported()) {
            is = new PushbackInputStream(is, 8);
        }

        if (POIFSFileSystem.hasPOIFSHeader(is)) {
            POIFSFileSystem fs = new POIFSFileSystem(is);
            EncryptionInfo info = new EncryptionInfo(fs);
            Decryptor d = Decryptor.getInstance(info);
            d.verifyPassword(password);
            is = d.getDataStream(fs);
        }

        System.out.println(is.available());
        XSSFWorkbook wb = new XSSFWorkbook(OPCPackage.open(is));
        fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.flush();
    } finally {
        if (is != null) {
            is.close();
        }
        if (fileOut != null) {
            fileOut.close();
        }
    }
}