for(int i=0; i<length; i++) {
    try {
        String srcFile = "file:///store/home/user/sample/www" + resourseFileNames[i];
        FileConnection srcConn = (FileConnection) Connector.open(srcFile, Connector.READ);
        InputStream in = srcConn.openInputStream();

        String dstFile = "file:///SDCard/myAppName/www" + resourseFileNames[i];
        FileConnection dstConn = (FileConnection)Connector.open(dstFile, Connector.WRITE);
        OutputStream out = dstConn.openOutputStream();

        // Copy the bits from instream to outstream
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
           out.write(buf, 0, len);
        }

        in.close();
        srcConn.close();

        out.close();
        dstConn.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}