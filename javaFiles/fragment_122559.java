public class PropertiesWSS4JInInterceptor extends WSS4JInInterceptor {

    private Properties cryptoProperties;

    public PropertiesWSS4JInInterceptor(Map<String, Object> inProps,
                                        Properties cryptoProperties) {
        super(inProps);
        this.cryptoProperties = cryptoProperties;
    }

    @Override
    protected Crypto loadCrypto(String cryptoPropertyFile, String cryptoPropertyRefId,
                                RequestData requestData) throws WSSecurityException {
        return CryptoFactory.getInstance(cryptoProperties);
    }
}