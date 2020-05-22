InputStream  inStream = null;
OutputStream outStream = null;

    try {
        File fromFile = new File("startfolder\\filename.txt");
        File toFile   = new File("endfolder\\filename.txt");

        inStream  = new FileInputStream(fromFile);
        outStream = new FileOutputStream(toFile);

        byte[] buffer = new byte[1024];

        int length;
        while ((length = inStream.read(buffer)) > 0){
            outStream.write(buffer, 0, length);
        }

        inStream.close();
        outStream.close();

        fromFile.delete();

    } catch(IOException e) {
        e.printStackTrace();
    }