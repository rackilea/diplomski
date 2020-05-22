// soapClient extends WebServiceGatewaySupport
soapClient.setInterceptors(new ClientInterceptor[]{new ClientInterceptor() {
        @Override
        public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                messageContext.getRequest().writeTo(os);
            } catch (IOException e) {
                throw new WebServiceIOException(e.getMessage(), e);
            }

            String request = new String(os.toByteArray());
            logger.trace("Request Envelope: " + request);
            return true;
        }

        @Override
        public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                messageContext.getResponse().writeTo(os);
            } catch (IOException e) {
                throw new WebServiceIOException(e.getMessage(), e);
            }

            String response = new String(os.toByteArray());
            logger.trace("Response Envelope: " + response);
            return true;
        }
        ...