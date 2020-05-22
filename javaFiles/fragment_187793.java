private byte[] decryptWithLWCrypto(byte[] cipher, String password, byte[] salt, final  int iterationCount)
        throws Exception
{
    PKCS12ParametersGenerator pGen = new PKCS12ParametersGenerator(new SHA256Digest());
    char[] passwordChars = password.toCharArray();
    final byte[] pkcs12PasswordBytes = PBEParametersGenerator
            .PKCS12PasswordToBytes(passwordChars);
    pGen.init(pkcs12PasswordBytes, salt, iterationCount);
    CBCBlockCipher aesCBC = new CBCBlockCipher(new AESEngine());
    ParametersWithIV aesCBCParams = (ParametersWithIV) pGen.generateDerivedParameters(256, 128);
    aesCBC.init(false, aesCBCParams);
    PaddedBufferedBlockCipher aesCipher = new PaddedBufferedBlockCipher(aesCBC,
            new PKCS7Padding());
    byte[] plainTemp = new byte[aesCipher.getOutputSize(cipher.length)];
    int offset = aesCipher.processBytes(cipher, 0, cipher.length, plainTemp, 0);
    int last = aesCipher.doFinal(plainTemp, offset);
    final byte[] plain = new byte[offset + last];
    System.arraycopy(plainTemp, 0, plain, 0, plain.length);
    return plain;
}