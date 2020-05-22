String address = "http://localhost:8088/validate";
BlaBlaWebService service = new BlaBlaWebService();
BlaBlaProviderPort provider = ser.getBlaBlaProviderPort();
if (provider instanceof BindingProvider) {
    BindingProvider bindProvider = (BindingProvider)provider;
    bindProvider.getRequestContext().put(
        BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
} else {
   //log or fail if you want
}