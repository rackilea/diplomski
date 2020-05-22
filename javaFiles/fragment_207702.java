SecureRandom sr = SecureRandom.getInstanceStrong();
    byte[] salt = new byte[16];
    sr.nextBytes(salt);

    PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, 128 * 8);
    SecretKey key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec);
    Cipher aes = Cipher.getInstance("AES");
    aes.init(Cipher.ENCRYPT_MODE, key);