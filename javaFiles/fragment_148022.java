public static String fileToBase64(String path) throws IOException {
    byte[] bytes = fileToByteArray(path);
    return Base64.encodeBytes(bytes);
}

public static byte[] fileToByteArray(String path) throws IOException {
    File imagefile = new File(path);
    byte[] data = new byte[(int) imagefile.length()];
    FileInputStream fis = new FileInputStream(imagefile);
    fis.read(data);
    fis.close();
    return data;
}


public static void base64ToFile(String path, String strBase64)
        throws IOException {
    byte[] bytes = Base64.decode(strBase64);
    byteArrayTofile(path, bytes);
}

public static void byteArrayTofile(String path, byte[] bytes)
        throws IOException {
    File imagefile = new File(path);
    File dir = new File(imagefile.getParent());
    if (!dir.exists()) {
        dir.mkdirs();
    }
    FileOutputStream fos = new FileOutputStream(imagefile);
    fos.write(bytes);
    fos.close();
}