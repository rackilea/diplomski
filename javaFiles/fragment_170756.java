/**
 * Generates a key and an initialization vector (IV) with the given salt and password.
 * <p>
 * This method is equivalent to OpenSSL's EVP_BytesToKey function
 * (see https://github.com/openssl/openssl/blob/master/crypto/evp/evp_key.c).
 * By default, OpenSSL uses a single iteration, MD5 as the algorithm and UTF-8 encoded password data.
 * </p>
 * @param keyLength the length of the generated key (in bytes)
 * @param ivLength the length of the generated IV (in bytes)
 * @param iterations the number of digestion rounds 
 * @param salt the salt data (8 bytes of data or <code>null</code>)
 * @param password the password data (optional)
 * @param md the message digest algorithm to use
 * @return an two-element array with the generated key and IV
 */
public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

    int digestLength = md.getDigestLength();
    int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
    byte[] generatedData = new byte[requiredLength];
    int generatedLength = 0;

    try {
        md.reset();

        // Repeat process until sufficient data has been generated
        while (generatedLength < keyLength + ivLength) {

            // Digest data (last digest if available, password data, salt if available)
            if (generatedLength > 0)
                md.update(generatedData, generatedLength - digestLength, digestLength);
            md.update(password);
            if (salt != null)
                md.update(salt, 0, 8);
            md.digest(generatedData, generatedLength, digestLength);

            // additional rounds
            for (int i = 1; i < iterations; i++) {
                md.update(generatedData, generatedLength, digestLength);
                md.digest(generatedData, generatedLength, digestLength);
            }

            generatedLength += digestLength;
        }

        // Copy key and IV into separate byte arrays
        byte[][] result = new byte[2][];
        result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
        if (ivLength > 0)
            result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

        return result;

    } catch (DigestException e) {
        throw new RuntimeException(e);

    } finally {
        // Clean out temporary data
        Arrays.fill(generatedData, (byte)0);
    }
}