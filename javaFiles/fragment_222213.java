private static final SecureRandom random = new SecureRandom();

/**
 * One-way encrypts (hashes) the given password.
 * 
 * @param saltpw  the salt (will be generated when null)
 * @param pw      the password to encrypt
 * @return        encrypted salted password
 */
public static String encrypt(String saltpw, String pw) throws GeneralSecurityException {
    byte[] salt;
    if (saltpw == null) {
        salt = new byte[16];
        random.nextBytes(salt);
    } else {
        salt = Base64.getDecoder().decode(saltpw.replaceFirst("\\$.*", ""));
    }
    KeySpec spec = new PBEKeySpec(pw.toCharArray(), salt, 100000, 256);
    SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    byte[] hash = f.generateSecret(spec).getEncoded();
    Base64.Encoder enc = Base64.getEncoder();
    return enc.encodeToString(salt) + "$" + enc.encodeToString(hash);
}

public static void main(String[] args) throws Exception {
    String enc = encrypt(null, "my-secret-password");
    System.out.printf("enc   : %s\n", enc);
    String test1 = encrypt(enc, "my-secret-password");
    System.out.printf("test 1: %s, valid: %b\n", test1, enc.equals(test1));
    String test2 = encrypt(enc, "some-other-password");
    System.out.printf("test 2: %s, valid: %b\n", test2, enc.equals(test2));
}