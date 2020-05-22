final Map<String,String> headers = new HashMap<>();

template.setInterceptors(new ClientInterceptor[]{new ClientInterceptor() {

        @Override
        public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
            return true;
        }

        @Override
        public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
            headers.put("foo", "bar");
            return false;
        }

        @Override
        public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
            return true;
        }

        @Override
        public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
        }
}});
template.marshalSendAndReceive(....);