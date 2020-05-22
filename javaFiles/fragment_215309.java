Security.addProvider(new BouncyCastleProvider());

// get cert
X509Certificate rootCert =
        (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(
                new BufferedInputStream(OwapiTestHandler.class.getResourceAsStream("/comodo-ecc-ca.crt"))
        );
X509Certificate domainCert =
        (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(
                new BufferedInputStream(OwapiTestHandler.class.getResourceAsStream("/comodo-ecc-domain-ca.crt"))
        );
X509Certificate sniCert =
        (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(
                new BufferedInputStream(OwapiTestHandler.class.getResourceAsStream("/sni235897.cloudflaressl.com.crt"))
        );

// add cert to keystore
KeyStore keystore = KeyStore.getInstance("PKCS12", BouncyCastleProvider.PROVIDER_NAME);
keystore.load(null, "".toCharArray());
keystore.setCertificateEntry("comodo-ecc-ca", rootCert);
keystore.setCertificateEntry("comodo-ecc-doman-ca", domainCert);
keystore.setCertificateEntry("cloudflair-sni", sniCert);