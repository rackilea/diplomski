public void handleMessage(SoapMessage message) throws Fault {
    List<WSHandlerResult> results = CastUtils.cast((List<?>) message
        .get(WSHandlerConstants.RECV_RESULTS));
    for (WSHandlerResult wshr : results) {
        for (WSSecurityEngineResult wsser : wshr.getResults()) {
            PublicKey publicKey = wsser
                .get(WSSecurityEngineResult.TAG_PUBLIC_KEY);
        }
    }
}