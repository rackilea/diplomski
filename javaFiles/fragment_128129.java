public List<WSSecurityEngineResult> handleToken(Element elem, RequestData data, AlgorithmSuite algorithmSuite) {
    // ...
    if (WSConstants.KEYTRANSPORT_RSA15.equals(encryptedKeyTransportMethod)
        && !data.isAllowRSA15KeyTransportAlgorithm() // <=== because this is false, etc.
        && (algorithmSuite == null
          || !algorithmSuite.getKeyWrapAlgorithms().contains(WSConstants.KEYTRANSPORT_RSA15))) {
        LOG.debug(
            "The Key transport method does not match the requirement"
        );
        throw new WSSecurityException(WSSecurityException.ErrorCode.INVALID_SECURITY); // <=== this is where you die
    }
    // ...
}