Client client = ClientBuilder.newClient();
HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();

HTTPClientPolicy policy = new HTTPClientPolicy();
policy.setProxyServer("my.proxy.domain");
policy.setProxyServerPort(80);
conduit.setClient(policy);

ProxyAuthorizationPolicy policy = new ProxyAuthorizationPolicy();
policy.setAuthorizationType("Basic");
policy.setUserName(PROXY_USER);
policy.setPassword(PROXY_PWD);
conduit.setProxyAuthorization(policy);