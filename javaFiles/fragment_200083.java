private static byte[] convertImageToByteArray(File file) throws FileNotFoundException, IOException {
    InputStream is = new FileInputStream(file );
    long length = file.length();
    if (length > Integer.MAX_VALUE) {
        System.out.println("Fichier trop volumineux.");
    }
    byte[] bytes = new byte[(int)length];
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length  && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
        offset += numRead;
    }
    if (offset < bytes.length) {
        System.out.println("Impossible de lire en entier le fichier: " + file.getName());
    }
    is.close();
    return bytes;
}