//outputPath is the path to the destination file.

    //Decode base64 String (automatically detects and decompresses gzip)
    byte[] data = Base64.decode(base64str);
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(outputPath);
        //Write data to file
        fos.write(data);
    } catch(IOException e) {
        e.printStackTrace();
    } finally {
        if(fos != null)
            try { fos.close(); }
            catch(IOException e) {}
    }