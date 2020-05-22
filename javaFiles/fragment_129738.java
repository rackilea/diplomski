package answer;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Arrays;

import java.text.SimpleDateFormat;

import java.io.ByteArrayOutputStream;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.util.Base64;

public class SO56189889 {
    public static void main(String[] args) {
        String auth_key = "d4eee068-272a-4aec-9681-5e16dcef6fbd";
        SimpleDateFormat var0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.US);
        var0.setTimeZone(TimeZone.getTimeZone("UTC"));

        // random key from /keys endpoint
        String formatted = var0.format(getSeedDate());

        String payload = auth_key + "|" + formatted;
        System.out.println(payload);
        String outputVal = magic(payload, "bd1676b5-5ce3-4351-a39b-36a7b7219c11"); // x-vmob-uid
        System.out.println(outputVal.length());
        System.out.println(outputVal);
    }

    public static Date getSeedDate() {
        Date now = new Date(Long.valueOf((new Date()).getTime() - 1000 * 10 * 60));
        return now;
    }

    public static String magic(String str, String str2) {
        try {
            byte[] bArr = new byte[8];
            // new SecureRandom().nextBytes(bArr);
            for (int i = 0; i < 8; i++) {
                bArr[i] = 'X';
            }
            String temp = new String(bArr);
            System.out.println(temp);

            byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
                    .generateSecret(new PBEKeySpec(str2.toCharArray(), bArr, 100, 384)).getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOfRange(encoded, 0, 32), "AES");

            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // XXX: use Cipher.ENCRYPT_MODE (was: instance.ENCRYPT_MODE)
            instance.init(Cipher.ENCRYPT_MODE, secretKeySpec,
                    new IvParameterSpec(Arrays.copyOfRange(encoded, 32, 48)));
            byte[] doFinal = instance.doFinal(str.getBytes("UTF-8"));

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(doFinal);
            byteArrayOutputStream.write(bArr);

            System.out.println("no exception, everything OK");

            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            System.out.println(e.toString());
            return "NOT WORKING";
        }
    }
}