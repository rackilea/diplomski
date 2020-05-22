import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public static String encrypt(String text) throws Exception
{
    SecretKeySpec sksSpec = new SecretKeySpec(key.getBytes(), algo );
    Cipher cipher = Cipher.getInstance(algo);
    cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, sksSpec);

    byte[] encrypt_bytes = cipher.doFinal(text.getBytes());
    return new String( Base64.encodeBase64(encrypt_bytes) );
}

public static String decrypt(String encrypt_str) throws Exception
{
    SecretKeySpec sksSpec = new SecretKeySpec(key.getBytes(), algo);
    Cipher cipher = Cipher.getInstance(algo);
    cipher.init(Cipher.DECRYPT_MODE, sksSpec);

    return new String(cipher.doFinal( Base64.decodeBase64(encrypt_str.getBytes("UTF-8"))));
}