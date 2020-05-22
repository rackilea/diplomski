private void setProxy()
{
    if(proxyUrl != null)
    {
        SocketAddress addr = new InetSocketAddress(proxyUrl, proxyPort);
        proxy = new Proxy(Proxy.Type.HTTP, addr);
    }
    else
    {
        proxy = Proxy.NO_PROXY;
    }       
}