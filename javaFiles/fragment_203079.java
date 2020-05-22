String mResponse;
    File file = new File(*path*, *name*);
    try {
        FileInputStream is = new FileInputStream(file);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        mResponse = new String(buffer);
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }