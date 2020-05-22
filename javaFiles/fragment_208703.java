import java.io.IOException;
import java.io.File;
import java.io.DataInputStream;
import java.io.FileInputStream ;
import java.lang.reflect.UndeclaredThrowableException;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Stack
{
    public static String hashToHexString(byte[] hash)
    {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i  0) {
            hexString.append('0');
        }
        hexString.append(hexByte);
    }
        return hexString.toString();
    }

    public static void main(String[] args)
      throws NoSuchAlgorithmException, InvalidKeyException

    {

        String secret = "12345678901234567890";
        byte[] keyBytes = secret.getBytes();
        String movingFact = "0";
        byte[] text = movingFact.getBytes();

        Mac hmacSha1;
        try {
          hmacSha1 = Mac.getInstance("HmacSHA1");
        } catch (Exception nsae) {
          hmacSha1 = Mac.getInstance("HMAC-SHA-1");         
        }
        SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
        hmacSha1.init(macKey);
        byte[] hash =  hmacSha1.doFinal(text);
        String hexString = hashToHexString(hash);
        System.out.println(hexString);
    }
}