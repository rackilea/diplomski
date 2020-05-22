import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

X509Certificate cert = // get certificate

byte[] value = cert.getExtensionValue("2.5.29.32");
if (value != null) { // extension is present
    // CertificatePolicies is a sequence
    DLSequence seq = (DLSequence) X509ExtensionUtil.fromExtensionValue(value);
    for (int i = 0; i < seq.size(); i++) {
        // each element is also a sequence
        DLSequence s = (DLSequence) seq.getObjectAt(i);
        // first element is an OID
        String oid = ((ASN1ObjectIdentifier) s.getObjectAt(0)).getId();
        if ("2.23.140.1.2.1".equals(oid)) {
            // DV
        } else if ("2.23.140.1.2.2".equals(oid)) {
            // OV
        }
    }
}