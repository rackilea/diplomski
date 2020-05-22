void downloadFromUrl(URL url, String localFilename) throws IOException {
    InputStream is = null;
    FileOutputStream fos = null;

    try {
        URLConnection urlConn = url.openConnection();//connect

        is = urlConn.getInputStream();               //get connection inputstream
        fos = new FileOutputStream(localFilename);   //open outputstream to local file

        byte[] buffer = new byte[4096];              //declare 4KB buffer
        int len;

        //while we have availble data, continue downloading and storing to local file
        while ((len = is.read(buffer)) > 0) {  
            fos.write(buffer, 0, len);
        }
    } finally {
        try {
            if (is != null) {
                is.close();
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}