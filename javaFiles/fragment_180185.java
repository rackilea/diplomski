WebClient webClient = WebClient.create(this.serviceURL,
    this.username,
    this.password,
    null); // Spring config file - we don't use this

if (trustAllCerts)
{
    HTTPConduit conduit = WebClient.getConfig(webClient)
        .getHttpConduit();

    TLSClientParameters params = 
        conduit.getTlsClientParameters();

    if (params == null) 
    {
        params = new TLSClientParameters();
        conduit.setTlsClientParameters(params);
    }

    params.setTrustManagers(new TrustManager[] { new
        DumbX509TrustManager() }); 

    params.setDisableCNCheck(true);
}