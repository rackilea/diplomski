MyService myService = new MyService();
        myPort = myService.getMyServiceHttpSoap11Endpoint();
        // See http://cxf.apache.org/docs/transformationfeature.html
        Client client = ClientProxy.getClient(myPort);

        Map<String, String> outTransformMap = Collections.singletonMap(
                "{http://myNamespace}*",
                "{http://myNamespace}*");
        org.apache.cxf.interceptor.transform.TransformOutInterceptor transformOutInterceptor =
                new org.apache.cxf.interceptor.transform.TransformOutInterceptor();
        transformOutInterceptor.setOutTransformElements(outTransformMap);
            client.getOutInterceptors().add(transformOutInterceptor);