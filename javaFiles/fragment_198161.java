Cipher c = constructCipher(encryptedKey.getEncryptionMethod()
                    .getAlgorithm(), encryptedKey.getEncryptionMethod()
                    .getDigestAlgorithm());

Instead of calling 
    c.init(4, key, oaepParameters);
used below code and removed if/else block
    c.init(4, key);