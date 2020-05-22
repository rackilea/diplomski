try {
    ClientResponse response = webResource.header(HttpHeaders.AUTHORIZATION, encodedHashString).type(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, formData);
} catch(ClientHandlerException ex) {
    handleClientHandlerException(ex);
}

private void handleClientHandlerException(ClientHandlerException ex) throws ClientHandlerException {
    if (ex.getCause() instanceof SocketTimeoutException) {
        // handelling SocketTimeoutException code here
    }
    throw ex;
}