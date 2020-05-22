DynamicClientFactory dcf = DynamicClientFactory.newInstance();
    Client client = dcf.createClient("WSDL Location");

    AuthorizationPolicy authorization = ((HTTPConduit) client.getConduit()).getAuthorization();

    authorization.setUserName(
            "user name"
    );

    authorization.setPassword(
            "password"
    );

    Object[] res = client.invoke(new QName("http://targetNameSpace/", "operationName"), params...);
    System.out.println("Echo response: " + res[0]);