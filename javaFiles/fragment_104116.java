public byte[] readFileBytes(String filename) throws IOException
{
    Path path = Paths.get(filename);
    return Files.readAllBytes(path);        
}

public PublicKey readPublicKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
{
    X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(readFileBytes(filename));
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePublic(publicSpec);       
}

public PrivateKey readPrivateKey(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
{
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(readFileBytes(filename));
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(keySpec);     
}