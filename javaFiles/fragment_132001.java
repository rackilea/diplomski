static final Provider ELYTRON_PROVIDER = new WildFlyElytronPasswordProvider();
static final String TEST_PASSWORD = "myPassword";

public static void main(String[] args) throws Exception {
    PasswordFactory passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, ELYTRON_PROVIDER);

    int iterationCount = 10;

    byte[] salt = new byte[BCryptPassword.BCRYPT_SALT_SIZE];
    SecureRandom random = new SecureRandom();
    random.nextBytes(salt);

    IteratedSaltedPasswordAlgorithmSpec iteratedAlgorithmSpec = new IteratedSaltedPasswordAlgorithmSpec(iterationCount, salt);
    EncryptablePasswordSpec encryptableSpec = new EncryptablePasswordSpec(TEST_PASSWORD.toCharArray(), iteratedAlgorithmSpec);

    BCryptPassword original = (BCryptPassword) passwordFactory.generatePassword(encryptableSpec);

    byte[] hash = original.getHash();

    Encoder encoder = Base64.getEncoder();
    System.out.println("Encoded Salt = " + encoder.encodeToString(salt));
    System.out.println("Encoded Hash = " + encoder.encodeToString(hash));
}