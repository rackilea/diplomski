...
try {
    URL url = new URL(urlString);

    System.out.println("Reading..." + url);

    Authenticator.setDefault(new ProxyAuthenticator("username", "password");

    SocketAddress addr = new InetSocketAddress("proxy.server.com", 80);
    Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

    HttpURLConnection conn = (HttpURLConnection)url.openConnection(proxy);

    ...