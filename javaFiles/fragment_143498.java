import org.bouncycastle.openssl.PKCS8Generator;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.openssl.jcajce.JcaPKCS8Generator;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8EncryptorBuilder;
import org.bouncycastle.openssl.jcajce.JcePEMEncryptorBuilder;
import org.bouncycastle.util.io.pem.PemWriter;

        // for the OpenSSL legacy form
        JcaPEMWriter x = new JcaPEMWriter (new OutputStreamWriter(System.out)); // or whatever 
        x.writeObject(kv, new JcePEMEncryptorBuilder("DES-EDE3-CBC").build("password".toCharArray()) );
        // can substitute AES-{128,192,256}-CBC if desired, for more see source
        x.close(); // or flush to keep underlying writer/stream

        // for the PKCS8 form
        PemWriter y = new PemWriter (new OutputStreamWriter(System.out)); // or whatever 
        y.writeObject(new JcaPKCS8Generator (kv, new JceOpenSSLPKCS8EncryptorBuilder(
                PKCS8Generator.DES3_CBC).setPasssword("password".toCharArray()).build() ) );
        // or AES_{128,192,256}_CBC, others will use PBES1 which is deprecated
        y.close(); // or flush to keep underlying writer/stream