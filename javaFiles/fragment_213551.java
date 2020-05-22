// renamed as crypto is a horrible name
public class FileEncryptor {

    // lets use all uppercase constant names
    public static final int AES_KEY_SIZE = 256;

    // only field needed, the rest can be generated on the fly
    private final KeyParameter key;

    public FileEncryptor() throws NoSuchAlgorithmException {
        key = generateKey();
    }

    private static KeyParameter generateKey() {
        // removed KeyGenerator as that's dependent on JCA crypto-API 
        SecureRandom keyRNG = new SecureRandom();
        byte[] keyData = new byte[AES_KEY_SIZE / Byte.SIZE];
        keyRNG.nextBytes(keyData);
        return new KeyParameter(keyData);
    }

    // the code doesn't do anything with zip itself, so no need to include it in the method name
    public void encryptFile(File plaintextFile, File ciphertextFile) throws IOException, DataLengthException, IllegalStateException, InvalidCipherTextException {
        byte[] plaintext = Files.readAllBytes(plaintextFile.toPath());
        byte[] ciphertext = encrypt(plaintext);
        // try and be symmetric, use Files functionality for reading *and writing*
        Files.write(ciphertextFile.toPath(), ciphertext);
    }


    private byte[] encrypt(byte[] plaintext) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        // create cipher
        final BlockCipher aes = new AESFastEngine();
        CBCBlockCipher aesCBC = new CBCBlockCipher(aes);
        PaddedBufferedBlockCipher aesCBCPadded =
                new PaddedBufferedBlockCipher(aesCBC, new PKCS7Padding());

        // create IV
        byte[] iv = new byte[aes.getBlockSize()];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        // initialize cipher with IV
        ParametersWithIV paramsWithIV = new ParametersWithIV(key, iv);
        aesCBCPadded.init(true, paramsWithIV); // problem here

        // encrypt
        byte[] ciphertext = new byte[aesCBCPadded.getOutputSize(plaintext.length)];
        int bytesWrittenOut = aesCBCPadded.processBytes(
            plaintext, 0, plaintext.length, ciphertext, 0);
        aesCBCPadded.doFinal(ciphertext, bytesWrittenOut);

        // that's great, but where is your IV now? you need to include it in the returned ciphertext!
        return ciphertext;
    }
}