GVAPI20De service1 = new GVAPI20De();

        GKVAPIServicePortType port2 = service1.getGKVAPISOAP11Port0();

        CreateShipmentOrderRequest sh = new CreateShipmentOrderRequest();
        //Setting up shipment;

        Map<String, Object> req_ctx = ((BindingProvider)port2).getRequestContext();

        //you may not need this and can try commenting it out
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://cig.dhl.de/cig-wsdls/com/dpdhl/wsdl/geschaeftskundenversand-api/2.2/geschaeftskundenversand-api-2.2.wsdl");

        //optional timeout
        req_ctx.put("javax.xml.ws.client.connectionTimeout", "60000");

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Authorization", Collections.singletonList("Basic c3gh567sd4689k11lg=="));

        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        CreateShipmentOrderResponse chr = port2.createShipmentOrder(sh)