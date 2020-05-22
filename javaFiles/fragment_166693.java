public class Decrypt {

    public static void main(String[] args) {
        try
        {
            String data = "aK7+UX24ttBgfTnAndz9aQ==" ;
            String key = "1234567812345678";
            String iv = "1234567812345678";

            Decoder decoder = Base64.getDecoder();   
             byte[] encrypted1 = decoder.decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            System.out.println(originalString.trim());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}