private String executeGet(final String https_url, final String proxyName, final int port) {
    String ret = "";

    URL url;
    try {

        HttpsURLConnection con;
        url = new URL(https_url);

        if (proxyName.isEmpty()) {  
            con = (HttpsURLConnection) url.openConnection();
        } else {                
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyName, port));
            con = (HttpsURLConnection) url.openConnection(proxy);
            Authenticator authenticator = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                        return (new PasswordAuthentication(USERNAME, PASSWORD.toCharArray()));
                    }
                };
            Authenticator.setDefault(authenticator);
        }

        ret = getContent(con);

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return ret;
}