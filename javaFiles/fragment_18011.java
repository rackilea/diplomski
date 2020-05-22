Cipher encryptionCipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA256AndMGF1Padding", "BC");
OAEPParameterSpec oaepParameterSpec = new OAEPParameterSpec("SHA-256", "MGF1",
                MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParameterSpec);
// ...
// ...
// ...
Cipher decryptionCipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING");
oaepParameterSpec = new OAEPParameterSpec("SHA-256", "MGF1",
                MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey, oaepParameterSpec);