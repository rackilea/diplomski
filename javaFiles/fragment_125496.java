//encrypt password
 String ALGORITHM = "PBKDF2WithHmacSHA256";
 String KEYPATH = "/home/apiuser/toto";
 String SECRET = "SECRET";
 int ITERATIONCOUNT = 65536;
 int KEYSIZE = 256;
 String password = "pass";
   SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);

    PBEKeySpec spec = new PBEKeySpec(SECRET.toCharArray(), salt.getBytes(), ITERATIONCOUNT, KEYSIZE);
    SecretKey secretKey = factory.generateSecret(spec);
    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secret);
    byte[] ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
    Map<String,String> encryptedPasswords = new HashMap<String,String>();
    byte[] encryptedTextBytes = cipher.doFinal(password.getBytes("UTF-8"));
        byte[] finalByteArray = new byte[ivBytes.length + encryptedTextBytes.length];
        System.arraycopy(ivBytes, 0, finalByteArray, 0, ivBytes.length);
        System.arraycopy(encryptedTextBytes, 0, finalByteArray, ivBytes.length, encryptedTextBytes.length);
        String encryptedpass= DatatypeConverter.printBase64Binary(finalByteArray);

public static String generateSalt() {

        return KeyGenerators.string().generateKey();
    }

   //decrypt password
   String ALGORITHM = "PBKDF2WithHmacSHA256";
    String SECRET = "SECRET";
    String key = "salt_key";
    String encryptedPasswords = "encodedpass";
                    encryptedPassword = encryptedPasswords.get(key);
                if (encryptedPassword.length() <= IV_LENGTH) {
                    throw new Exception("The input string is not long enough to contain the initialisation bytes and data.");
                }
                byte[] byteArray = DatatypeConverter.parseBase64Binary(encryptedPassword);
                byte[] ivBytes = new byte[IV_LENGTH];
                System.arraycopy(byteArray, 0, ivBytes, 0, 16);
                byte[] encryptedTextBytes = new byte[byteArray.length - ivBytes.length];
                System.arraycopy(byteArray, IV_LENGTH, encryptedTextBytes, 0, encryptedTextBytes.length);
                SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
                PBEKeySpec spec = new PBEKeySpec(SECRET.toCharArray(), key.getBytes(), 65536, 256);
                SecretKey secretKey = factory.generateSecret(spec);
                SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));
                byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);