import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class DecodeEcdsaSignature {

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        byte[] signature = getSignature();      
        ASN1Primitive asn1 = toAsn1Primitive(signature);

        if (asn1 instanceof ASN1Sequence) {
            ASN1Sequence asn1Sequence = (ASN1Sequence) asn1;
            ASN1Encodable[] asn1Encodables = asn1Sequence.toArray();
            for (ASN1Encodable asn1Encodable : asn1Encodables) {
                ASN1Primitive asn1Primitive = asn1Encodable.toASN1Primitive();
                if (asn1Primitive instanceof ASN1Integer) {
                    ASN1Integer asn1Integer = (ASN1Integer) asn1Primitive;
                    BigInteger integer = asn1Integer.getValue();
                    System.out.println(integer.toString());
                }
            }
        }

    }

    private static ASN1Primitive toAsn1Primitive(byte[] data) throws Exception
    {
        try (ByteArrayInputStream inStream = new ByteArrayInputStream(data);
                ASN1InputStream asnInputStream = new ASN1InputStream(inStream);) 
        {
            return asnInputStream.readObject();
        }
    }

    private static byte[] getSignature() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA");
        ECGenParameterSpec ecParameterSpec = new ECGenParameterSpec("P-256");
        keyPairGenerator.initialize(ecParameterSpec);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(keyPair.getPrivate());
        signature.update("message to sign".getBytes("UTF-8"));

        return signature.sign();
    }

}