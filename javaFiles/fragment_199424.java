import java.math.BigInteger;
import java.security.SecureRandom;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.generators.DHParametersGenerator;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.encoders.Base64;

public class OpenSSLDHParamClone
{

    public static void main(String[] args) throws Exception
    {
        DHParametersGenerator generator = new DHParametersGenerator();
        generator.init(1024, 80, new SecureRandom());
        DHParameters params = generator.generateParameters();
        // Generator G is set as random in params, but it has to be 2 to conform to openssl
        DHParameters realParams = new DHParameters(params.getP(), BigInteger.valueOf(2));
        ASN1EncodableVector seq = new ASN1EncodableVector();
        seq.add(new DERInteger(realParams.getP()));
        seq.add(new DERInteger(realParams.getG()));
        byte [] derEncoded = new DERSequence(seq).getDEREncoded();
        System.out.println("-----BEGIN DH PARAMETERS-----");
        String b64Encoded = new String(Base64.encode(derEncoded), "US-ASCII");
        while (b64Encoded.length() > 0) {
            int subStringLength = Math.min(64, b64Encoded.length());
            System.out.println(b64Encoded.substring(0, subStringLength));
            b64Encoded = b64Encoded.substring(subStringLength);
        }
        System.out.println("-----END DH PARAMETERS-----");
    }
}