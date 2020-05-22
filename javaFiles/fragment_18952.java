MyApp_Service service = new MyApp_Service(wsdlUrl, new QName(namespace, serviceName));
        MyApp port = service.getMyApp();

        // Set credentials
        Map<String, Object> reqCtxt = ((javax.xml.ws.BindingProvider) port).getRequestContext();
        reqCtxt.put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, username);
        reqCtxt.put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, password);