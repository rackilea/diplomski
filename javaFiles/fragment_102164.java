public class ResourceLoaderUserAgent extends ITextUserAgent {

public ResourceLoaderUserAgent(ITextOutputDevice outputDevice) {
    super(outputDevice);
}

protected InputStream resolveAndOpenStream(String uri) {    

    HttpURLConnection connection = null;
    URL proxyUrl = null;
    try {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 3128));
        proxyUrl = new URL(uri);
        connection = (HttpURLConnection) proxyUrl.openConnection(proxy);
        connection.connect();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    java.io.InputStream is = null;
    try {
        is = connection.getInputStream();
    } catch (java.net.MalformedURLException e) {
        XRLog.exception("bad URL given: " + uri, e);
    } catch (java.io.FileNotFoundException e) {
        XRLog.exception("item at URI " + uri + " not found");
    } catch (java.io.IOException e) {
        XRLog.exception("IO problem for " + uri, e);
    }

    return is;
}
}