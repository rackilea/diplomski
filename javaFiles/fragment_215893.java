// generate a relatively small key for testing
KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
kpg.initialize(2048);
KeyPair kp = kpg.generateKeyPair();

// OAEP spec with label
OAEPParameterSpec spec = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1,
        new PSource.PSpecified("label".getBytes(US_ASCII)));

// OAEP spec without label
OAEPParameterSpec specEmpty = new OAEPParameterSpec("SHA-1", "MGF1", MGF1ParameterSpec.SHA1,
        PSource.PSpecified.DEFAULT);

byte[] ct;
{
    // encrypt to ciphertext using label
    Cipher rsaOAEPEnc = Cipher.getInstance("RSA/ECB/OAEPPadding");
    rsaOAEPEnc.init(Cipher.ENCRYPT_MODE, kp.getPublic(), spec);
    ct = rsaOAEPEnc.doFinal("owlstead".getBytes(US_ASCII));
}

{
    // decrypt with label
    Cipher rsaOAEPDec = Cipher.getInstance("RSA/ECB/OAEPPadding");
    rsaOAEPDec.init(Cipher.DECRYPT_MODE, kp.getPrivate(), spec);
    byte[] pt = rsaOAEPDec.doFinal(ct);
    System.out.println(new String(pt, US_ASCII));
}

{
    // decrypt without label (fails with an exception)
    Cipher rsaOAEPDec = Cipher.getInstance("RSA/ECB/OAEPPadding");
    rsaOAEPDec.init(Cipher.DECRYPT_MODE, kp.getPrivate(), specEmpty);
    byte[] pt = rsaOAEPDec.doFinal(ct);
    System.out.println(new String(pt, US_ASCII));
}