// line 208
public WSHandlerResult processSecurityHeader(
    Element securityHeader,
    String actor,
    CallbackHandler cb,
    Crypto sigVerCrypto,
    Crypto decCrypto
) throws WSSecurityException {
    RequestData data = new RequestData(); // creates RequestData but doesn't set `allowRSA15KeyTransportAlgorithm`
    data.setActor(actor);
    data.setWssConfig(getWssConfig());
    data.setDecCrypto(decCrypto);
    data.setSigVerCrypto(sigVerCrypto);
    data.setCallbackHandler(cb);
    return processSecurityHeader(securityHeader, data); // line 221
}