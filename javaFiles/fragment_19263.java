public static int fileScan(String filename) throws IOException {
    File file = new File(filename);
    LineNumberReader lnr = null;
    try {
        lnr = new LineNumberReader(new FileReader(file));
        lnr.skip(file.length());//go to end of file
        return lnr.getLineNumber();
    } finally {
        if(null != lnr) {
            lnr.close();
        }
    }
}