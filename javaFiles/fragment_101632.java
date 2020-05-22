public byte[] decrypt(byte[] ciphertext) {
        try {
            ByteBuffer byteBuffer = ByteBuffer.wrap(ciphertext);
            byte[] iv = new byte[12];
            byteBuffer.get(iv);
            byte[] encrypted = new byte[byteBuffer.remaining()];
            byteBuffer.get(encrypted);
            decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, new GCMParameterSpec(keyLength, iv));
            return decryptCipher.doFinal(encrypted); // here was the mistake
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }