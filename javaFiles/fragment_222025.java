private GetCatalogResponse getCatalogData(GetCatalog getCat) throws AxisFault, GetCatalogExceptionException, RemoteException, Exception {

        ConfigurationContext ctx;
        ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("MainFolder/Config-Files/Axis2Repo","MainFolder/Config-Files/axis2.xml");

        PRODUCTCATALOGStub prodCat = new PRODUCTCATALOGStub(ctx, this.targetEndpoint);

        GetCatalogResponse wsResponse;

        // Basic Authentication
        Options option = prodCat._getServiceClient().getOptions();

        HttpClient httpClient = new DefaultHttpClient();

        HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();

        auth.setPreemptiveAuthentication(true);
        auth.setUsername(this.User);
        auth.setPassword(Kryptologie.entschluesseln(Crypto.decipher(this.pw)));
        option.setProperty(HTTPConstants.AUTHENTICATE, auth);
        option.setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);

        // calling the webservice
        wsResponse = prodCat.getCatalog(getCat);

        return wsResponse;

    }