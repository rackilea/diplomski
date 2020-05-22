public static void LZ4compress(String filename, String lz4file){
    byte[] buf = new byte[2048];
    try {
        String outFilename = lz4file;
        LZ4BlockOutputStream out = new LZ4BlockOutputStream(new FileOutputStream(outFilename), 32*1024*1024);
        FileInputStream in = new FileInputStream(filename);
        int len;
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    } catch (IOException e) {

    }
}

public static void LZ4Uncompress(String lz4file, String filename){
    byte[] buf = new byte[2048];
    try {
        String outFilename = filename;
        LZ4BlockInputStream in = new LZ4BlockInputStream(new FileInputStream(lz4file));
        FileOutputStream out = new FileOutputStream(outFilename);
        int len;
        while((len = in.read(buf)) > 0){
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    } catch (IOException e) {

    }
}