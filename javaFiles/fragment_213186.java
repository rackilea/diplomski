import sun.security.pkcs.*;
import sun.security.pkcs10.*; // separate in j8 (and later? not checked) 
import sun.security.util.*;
import sun.security.x509.*;

    // dummy setup; replace as appropriate
    X500Name name = new X500Name("O=Widgets Inc, CN=testcert");
    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize(1024); KeyPair pair = gen.generateKeyPair();

    KeyUsageExtension ku = new KeyUsageExtension();
    ku.set(KeyUsageExtension.NON_REPUDIATION, true);
    ku.set(KeyUsageExtension.KEY_ENCIPHERMENT, true);
    ku.set(KeyUsageExtension.DIGITAL_SIGNATURE, true);
    CertificateExtensions exts = new CertificateExtensions();
    exts.set(KeyUsageExtension.IDENT,ku);
    PKCS10Attribute extreq = new PKCS10Attribute (PKCS9Attribute.EXTENSION_REQUEST_OID, exts);

    PKCS10 csr = new PKCS10 (pair.getPublic(), new PKCS10Attributes (new PKCS10Attribute[]{ extreq }));
    Signature signer = Signature.getInstance("SHA256withRSA"); // or adapt to key 
    signer.initSign(pair.getPrivate());
    csr.encodeAndSign(name, signer);

    // dummy output; replace 
    FileOutputStream out = new FileOutputStream ("SO49985805.der");
    out.write(csr.getEncoded()); out.close();