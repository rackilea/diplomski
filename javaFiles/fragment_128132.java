private void inboundWSSConfig(SOAPMessageContext context, Crypto crypto) throws WSSecurityException{

    log.info("Inbound Message...");

    KeystoreCallbackHandler keystoreCallbackHandler = new KeystoreCallbackHandler();
    keystoreCallbackHandler.addUsers((String)cryptoProperties.get("org.apache.ws.security.crypto.merlin.keystore.alias"), 
    (String)cryptoProperties.get("org.apache.ws.security.crypto.merlin.keystore.password"));

    WSSecurityEngine newEngine = new WSSecurityEngine();
    WSSConfig config = WSSConfig.getNewInstance();
    config.setValidator(WSConstants.SIGNATURE, new SignatureTrustValidator());
    newEngine.setWssConfig(config);

    RequestData data = new RequestData();
    data.setWssConfig(config); // probably
    data.setDecCrypto(crypto);
    data.setSigVerCrypto(crypto);
    data.setCallbackHandler(keystoreCallbackHandler);
    data.setAllowRSA15KeyTransportAlgorithm(true);

    newEngine.processSecurityHeader(context.getMessage().getSOAPPart(), data);
}