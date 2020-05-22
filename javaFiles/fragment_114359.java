import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.Reader;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class SO {

    public PublicKey getPublicKey() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Reader rdr = new StringReader(
                "-----BEGIN PUBLIC KEY-----\n" +
                        "MEkwEwYHKoZIzj0CAQYIKoZIzj0DAQEDMgAEXMHnQfWiM4oCaLfx296llgz7iaVv\n" +
                        "avMPppkzVNZAxtlNLhFlXnNWD0Mw9yzP8/Go\n" +
                        "-----END PUBLIC KEY-----\n"
        ); // or from file etc.

        org.bouncycastle.util.io.pem.PemObject spki = new org.bouncycastle.util.io.pem.PemReader(rdr).readPemObject();
        PublicKey key = KeyFactory.getInstance("EC", "BC").generatePublic(new X509EncodedKeySpec(spki.getContent()));
        return key;
    }

    public static boolean verify(byte[] data, byte[] signatureBytes, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA", "BC");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signatureBytes);
    }

}