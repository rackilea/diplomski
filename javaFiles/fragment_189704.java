import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

X509Certificate cert = // end entity certificate

// get Authority Information Access extension (will be null if extension is not present)
byte[] extVal = cert.getExtensionValue(Extension.authorityInfoAccess.getId());
AuthorityInformationAccess aia = AuthorityInformationAccess.getInstance(X509ExtensionUtil.fromExtensionValue(extVal));

// check if there is a URL to issuer's certificate
AccessDescription[] descriptions = aia.getAccessDescriptions();
for (AccessDescription ad : descriptions) {
    // check if it's a URL to issuer's certificate
    if (ad.getAccessMethod().equals(X509ObjectIdentifiers.id_ad_caIssuers)) {
        GeneralName location = ad.getAccessLocation();
        if (location.getTagNo() == GeneralName.uniformResourceIdentifier) {
            String issuerUrl = location.getName().toString();
            // http URL to issuer (test in your browser to see if it's a valid certificate)
            // you can use java.net.URL.openStream() to create a InputStream and create
            // the certificate with your CertificateFactory
            URL url = new URL(issuerUrl);
            X509Certificate issuer = (X509Certificate) certificateFactory.generateCertificate(url.openStream());
        }
    }
}