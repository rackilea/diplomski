public void handleMessage(SoapMessage message) {

    String transaction = MDC.get("transaction");

    logger.info("Transaction ID: {} ", transaction);
    try {

         LogInUtil.logging(logger, message, transaction);
         }
        catch (Exception ex) {
           logger.warn("Unable to save SOAP Response due to {}",ex.getMessage());
        }
}