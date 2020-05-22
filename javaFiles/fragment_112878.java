public static void main(String[] args) {

    File inputfile = new File("file/to/be/encoded");
    File outFile = new File("out.uue");

    UUEncoder uuec = new UUEncoder();
    InputStream is = null;
    OutputStream os = null;
    try {

        is = new FileInputStream(inputfile);
        os = new FileOutputStream(outFile);
        uuec.encodeBuffer(is, os);

    } catch (Exception error) {
        error.printStackTrace();
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

    File newFile = new File("decoded.jpg");
    UUDecoder decoder = new UUDecoder();
    try {

        is = new FileInputStream(outFile);
        os = new FileOutputStream(newFile);
        decoder.decodeBuffer(is, os);

    } catch (Exception e) {
        e.printStackTrace();
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

}