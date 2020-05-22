CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", new BouncyCastleProvider());
InputStream is = new ByteArrayInputStream(some bytes in an array);
CertPath certPath = certificateFactory.generateCertPath(is, "PKCS7"); // Throws Certificate Exception when a cert path cannot be generated
CertPathValidator certPathValidator = CertPathValidator.getInstance("PKIX", new BouncyCastleProvider());
PKIXParameters parameters = new PKIXParameters(KeyTool.getCacertsKeyStore());

PKIXCertPathValidatorResult validatorResult = (PKIXCertPathValidatorResult) certPathValidator.validate(certPath, parameters); // This will throw a CertPathValidatorException if validation fails