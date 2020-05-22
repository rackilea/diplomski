private static String getJWT() throws Exception{

    File f = new File(privateKeyFile);
    InputStreamReader isr = new InputStreamReader(new FileInputStream(f));

    PEMParser pemParser = new PEMParser(isr);
    Object object = pemParser.readObject();
    PEMKeyPair kp = (PEMKeyPair) object;
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
    RSAPrivateKey privateKey = (RSAPrivateKey) converter.getPrivateKey(kp.getPrivateKeyInfo());
    pemParser.close();


    // Create RSA-signer with the private key
    JWSSigner signer = new RSASSASigner(privateKey);

    // Prepare JWT with claims set
    JWTClaimsSet claimsSet = new JWTClaimsSet();
    claimsSet.setSubject(applicationId);
    claimsSet.setAudience(Arrays.asList(apiEndpoint));
    claimsSet.setIssuer(applicationId);
    claimsSet.setExpirationTime(new Date(new Date().getTime() + 360 * 1000));

    claimsSet.setIssueTime(new Date(new Date().getTime()));
    claimsSet.setJWTID(UUID.randomUUID().toString());

    SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), claimsSet);

    // Compute the RSA signature
    signedJWT.sign(signer);

    String s = signedJWT.serialize();
    return s;
}