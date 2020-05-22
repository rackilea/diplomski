public Response submitTransaction(final TransactionRequest request) throws CommonFault {
        log.info("submitTransaction : "+ request.getId());
        JAXBElement<TransactionResponse> response = invokeService("TransactionsSubmit", objectFactory.createSubmitTransactionRequest(request));
        return response.getValue();
    }


private <T> JAXBElement<T> invokeService(final String serviceName, final JAXBElement<?> request) {
        log.info("Invoking service : " + serviceName + "()");
        JAXBElement<T> response = null;
        try {
            ServiceInvoker serviceInvoker = new ServiceInvoker("myservice", serviceName);
            Message message = org.jboss.soa.esb.message.format.MessageFactory.getInstance().getMessage();

            message.getBody().add(jaxbHandler.serialize(request));
            Message esbResponse = serviceInvoker.deliverSync(message, 5000);
            log.info("Response : " + esbResponse.getBody().get().toString());

            response = deserialize(esbResponse.getBody().get().toString());
        } catch (Exception e) {
            log.error(e, e);
        }
        return response;
}