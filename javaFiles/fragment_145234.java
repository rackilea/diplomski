SecretKey secretKey = null;
    KeyGenerator kgen = KeyGenerator.getInstance("AES");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    secureRandom.setSeed(sKey.getBytes());
    kgen.init(128, secureRandom);
    secretKey = kgen.generateKey();
    byte[] enCodeFormat = secretKey.getEncoded();