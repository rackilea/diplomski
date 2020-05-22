public WSHandlerResult processSecurityHeader(
    Document doc,
    String actor,
    CallbackHandler cb,
    Crypto crypto
) throws WSSecurityException {
    return processSecurityHeader(doc, actor, cb, crypto, crypto);
}