int iterations = 1000; // minimum
        int keySize = 256; // maximum
        final byte[] salt = new byte[8];
        SecureRandom rng = SecureRandom.getInstance("SHA1PRNG");
        rng.nextBytes(salt);
        char[] password = new char[] { 'o', 'w', 'l', 's', 't', 'e', 'a', 'd' };

        // S2 *is* PBKDF2, but the default used only HMAC(SHA-1)
        final PKCS5S2_SHA256_ParametersGenerator gen = new PKCS5S2_SHA256_ParametersGenerator();

        // lets not use String, as we cannot destroy strings, BC to the rescue!
        final byte[] pwBytes = Strings.toUTF8ByteArray(password);

        gen.init(pwBytes, salt, iterations);

        final KeyParameter params1 = (KeyParameter) gen.generateDerivedMacParameters(keySize);

        // use for/next loop for older Java versions, destroy password information in memory
        Arrays.fill(pwBytes, 0, pwBytes.length, (byte) 0);
        Arrays.fill(password, 0, password.length, ' ');
        final KeyParameter keyParam = params1;
        SecretKeySpec secretKey = new SecretKeySpec(keyParam.getKey().clone(), "AES");