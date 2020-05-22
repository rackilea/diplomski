public static  File encrypt(File f, byte[] key) throws Exception
{
    System.out.println("Starting Encryption");
    SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

    System.out.println(plainText.length);

    Path outPath = Paths.get("D:/Temp");
    byte[] plainBuf = new byte[8192];
    try (InputStream in = Files.newInputStream(f.toPath());
            OutputStream out = Files.newOutputStream(outPath)) {
        int nread;
        while ((nread = in.read(plainBuf)) > 0) {
            byte[] enc = cipher.update(plainBuf, 0, nread);
            out.write(enc);
        }       
        byte[] enc = cipher.doFinal();
        out.write(enc);
    }
    return outPath.toFile();
}