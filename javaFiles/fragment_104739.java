// code to create HttpRoute the same as in apache library
private HttpRoute getHttpRouteForUrl(String url) throws URISyntaxException
{
    URI uri = new URI(url);
    boolean secure = uri.getScheme().equalsIgnoreCase("https");
    int port = uri.getPort();
    if (uri.getPort() > 0)
    {
        port = uri.getPort();
    }
    else if (uri.getScheme().equalsIgnoreCase("https"))
    {
        port = 443;
    }
    else if (uri.getScheme().equalsIgnoreCase("http"))
    {
        port = 80;
    }
    else
    {
        LOGGER.warn("Unknown port of uri %s", repository);
    }
    HttpHost httpHost = new HttpHost(uri.getHost(), port, uri.getScheme());
    // TODO check whether we need this InetAddress as second param
    return new HttpRoute(httpHost, null, secure);
}