public String[] getPolicyAndSignature(String policy)
{
    try
    {
        String encodedPolicy = new String(Base64.encodeBase64(policy.getBytes()));

        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(new FileInputStream(new File("my_test_app/mykey.p12")), "notasecret".toCharArray());
        PrivateKey privateKey = (PrivateKey)keystore.getKey("privatekey", "notasecret".toCharArray());

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(encodedPolicy.getBytes());

        String encodedSignature = new String(Base64.encodeBase64(signature.sign(), false));

        return new String[]{encodedPolicy, encodedSignature};
    }
    catch(Exception e)
    {
        System.out.println("Error: " + e.getMessage());
    }
    return null;
}