public class SPCopyDriver
{

    public static void main(String[] args) {

        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(CopySoap.class);
        proxyFactory.setUsername("domain\\username");
        proxyFactory.setPassword("password");
        proxyFactory.setAddress("https://<<IP>>/_vti_bin/Copy.asmx");

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setAutoRedirect(true);
        httpClientPolicy.setAllowChunking(false);

        Object port = proxyFactory.create();
        Client client = ClientProxy.getClient(port);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        httpConduit.setClient(httpClientPolicy);

        TLSClientParameters tls = new TLSClientParameters();
        tls.setDisableCNCheck(true);
        tls.setTrustManagers(new TrustManager[] { new TrustingX509TrustManager() });
        httpConduit.setTlsClientParameters(tls);

        port = Proxy.newProxyInstance(SPCopyDriver.class.getClassLoader(), new Class[] { CopySoap.class }, new InvocationHandlerImpl((CopySoap) port));

        CopySoap copySoap = (CopySoap) port;

    }

}