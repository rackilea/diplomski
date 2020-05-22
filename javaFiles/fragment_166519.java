import org.bouncycastle.x509.extension.X509ExtensionUtil;

X509Certificate certificate = // a java.security.cert.X509Certificate
byte[] policyBytes = certificate.getExtensionValue(Extension.certificatePolicies.toString());
if (policyBytes != null) {
    CertificatePolicies policies = CertificatePolicies.getInstance(X509ExtensionUtil.fromExtensionValue(policyBytes));
    PolicyInformation[] policyInformation = policies.getPolicyInformation();
    for (PolicyInformation pInfo : policyInformation) {
        ASN1Sequence policyQualifiers = (ASN1Sequence) pInfo.getPolicyQualifiers().getObjectAt(0);
        System.out.println(policyQualifiers.getObjectAt(1)); // aaa.bbb
    }
}