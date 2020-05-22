//Connection
service = new ListingsService();
port = service.getListingsServiceSoap();
BindingProvider bindingProvider = (BindingProvider) port;
bindingProvider.getRequestContext()
.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
"http://api.rovicorp.com/v9/listingsservice.asmx?apikey=" + APIKey);