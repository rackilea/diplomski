import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.util.encoders.Base64;

String pem = // read contents from PEM file
// Convert to AC object
byte[] data = Base64.decode(pem.getBytes());
X509AttributeCertificateHolder holder = new X509AttributeCertificateHolder(data);