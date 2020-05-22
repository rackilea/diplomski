import org.bouncycastle.asn1.x509.CertificatePolicies;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.PolicyQualifierId;
import org.bouncycastle.asn1.x509.PolicyQualifierInfo;
import org.bouncycastle.cert.X509v3CertificateBuilder;

X509v3CertificateBuilder certGen = //create builder

boolean isCritical = true; // depends on your application (setting any value for tests)
PolicyQualifierInfo pqInfo = new PolicyQualifierInfo("aaa.bbb"); // the value you want
PolicyInformation policyInfo = new PolicyInformation(PolicyQualifierId.id_qt_cps, new DERSequence(pqInfo));
CertificatePolicies policies = new CertificatePolicies(policyInfo);
certGen.addExtension(Extension.certificatePolicies, isCritical, policies);