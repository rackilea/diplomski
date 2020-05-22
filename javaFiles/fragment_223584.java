public static void main(String[] args) {
    encryptFile("exampleInput.txt", "exampleOutput.txt");
}

public static void encryptFile(String source, String sink) {
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(source);
        CipherOutputStream cos = null;
        try {
            cos = new CipherOutputStream(new FileOutputStream(sink), getEncryptionCipher());
            IOUtils.copy(fis, cos);
        } finally {
            if (cos != null)
                cos.close();
        }
    } finally {
        if (fis != null)
            fis.close();
    }
}

private static Cipher getEncryptionCipher() {
    // Create AES cipher with whatever padding and other properties you want
    Cipher cipher = ... ;
    // Create AES secret key
    Key key = ... ;
    cipher.init(Cipher.ENCRYPT_MODE, key);
}