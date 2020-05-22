// Use no-arg constructor. Means it uses the WSDL bundled into the 
// META-INF/wsdl directory rather than trying to retrieve WSDL over the
// network.
service = new HelloSvc_Service();
hello = service.getHelloSvcPort();

// Since we're using a bundled WSDL the web service URL cannot 
// be derived from that (it would be wrong!). So we have to set
// it explicitly.
((BindingProvider) hello).getRequestContext().put(
                BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://myhellowebservice-address");