public class Test {
    static byte[] plaintext = new byte[] { 0x41, 0x42, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49, 0x4a, 0x4b, 0x4c, 0x4d, 0x4e, 0x4f, 0x50, 0x51,
            0x52, 0x53 };

    public static void main(String[] args) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5PADDING");
            String s_key = "Random09" + "Random09"; // 16 Byte = 128 Bit Key
            byte[] b_key = s_key.getBytes();
            SecretKeySpec sKeySpec = new SecretKeySpec(b_key, "AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            byte[] IV = new byte[16]; // initialization vector
            random.nextBytes(IV);
            int num = 10000;
            long start = System.nanoTime();
            for (int i = 0; i < num; ++i) {
                IvParameterSpec ivSpec = new IvParameterSpec(IV);
                cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, ivSpec);
                byte[] msg = new byte[16 + 32];
                System.arraycopy(IV, 0, msg, 0, IV.length);
                byte[] encrypted = cipher.doFinal(plaintext);
                System.arraycopy(encrypted, 0, msg, IV.length, encrypted.length);
                increment(IV);
            }
            long end = System.nanoTime();
            long duration = end - start;
            double drate = ((double) plaintext.length * (double) num) / ((double) duration / 1000000000);
            System.out.println("Verschlüsselung:\n" + num + " mal 19 Bytes in " + ((double) duration / 1000000000) + " s\nData Rate = " + drate
                    / 1000.0 + " kBytes/s");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void increment(byte[] iv) {
        for (int i=0; i<4; ++i) {
            if (++iv[i] != 0)
                break;
        }
    }
}