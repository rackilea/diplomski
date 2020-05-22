public class CipherStorageFactory {
    private String transformation;
    private String provider;
    private String providerPair;

    public CipherStorageFactory(String transformation, String provider, String providerPair){
        this.transformation = transformation;
        this.provider = provider;
        this.providerPair = providerPair;
    }

    public CipherStorage getCipher(String cipherType) {
        //...
        if (cipherType.equalsIgnoreCase("AES")) {
            return new CipherStorageAES(transformation, provider, providerPair);
        } else 
        //...
    }
}