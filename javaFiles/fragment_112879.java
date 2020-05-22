public void SettingUpload(File inputfile) throws IOException {
    UUEncoder uuec = new UUEncoder();
    File outFile = File.createTempFile("encoded", "uue");
    InputStream is = null;
    OutputStream os = null;
    try{
        is = new FileInputStream(inputfile);
        os = new FileOutputStream(outFile );
        uuec.encodeBuffer(is, os);
    } finally {
        try {
            is.close();
        } catch (Exception e) {
        }
            try {
        os.close();
        } catch (Exception e) {
        }
    }
    return outFile;
}