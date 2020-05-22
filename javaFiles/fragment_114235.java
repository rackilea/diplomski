import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.CollectionStore;

// add these lines after gen.addSignerInfoGenerator(...)

// cert is your X509Certificate
X509CertificateHolder holder = new X509CertificateHolder(cert.getEncoded());
CollectionStore<X509CertificateHolder> certStore = new CollectionStore<>(Collections.singletonList(holder));
gen.addCertificates(certStore); // add the store to the signature