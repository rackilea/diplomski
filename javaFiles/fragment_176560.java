import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
//import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

public class DumpPrivateKey {
     /**
     * Provides the missing functionality of keytool
     * that Apache needs for SSLCertificateKeyFile.
     *
     * @param args  <ul>
     *              <li> [0] Keystore filename.
     *              <li> [1] Keystore password.
     *              <li> [2] alias
     *              </ul>
     */
    static public void main(String[] args)
    throws Exception {
        if(args.length < 3) {
          throw new IllegalArgumentException("expected args: Keystore filename, Keystore password, alias, <key password: default same tha
n keystore");
        }
        final String keystoreName = args[0];
        final String keystorePassword = args[1];
        final String alias = args[2];
        final String keyPassword = getKeyPassword(args,keystorePassword);
        KeyStore ks = KeyStore.getInstance("jks");
        ks.load(new FileInputStream(keystoreName), keystorePassword.toCharArray());
        Key key = ks.getKey(alias, keyPassword.toCharArray());
        //String b64 = new BASE64Encoder().encode(key.getEncoded());
        String b64 = new String(Base64.encodeBase64(key.getEncoded(),true));
        System.out.println("-----BEGIN PRIVATE KEY-----");
        System.out.println(b64);
        System.out.println("-----END PRIVATE KEY-----");
    }
    private static String getKeyPassword(final String[] args, final String keystorePassword)
    {
       String keyPassword = keystorePassword; // default case
       if(args.length == 4) {
         keyPassword = args[3];
       }
       return keyPassword;
    }
}