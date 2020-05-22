public class OwnProxySelector extends ProxySelector {
private ProxySelector defaultProxySelector;
private Proxy intranetProxy;
private Proxy extranetProxy;
private Proxy directConnection = Proxy.NO_PROXY;
private URI intranetAddress;
private URI extranetAddress;


public OwnProxySelector(ProxySelector defaultProxySelector){
    this.defaultProxySelector = defaultProxySelector;
}

/* (non-Javadoc)
 * @see java.net.ProxySelector#connectFailed(java.net.URI, java.net.SocketAddress, java.io.IOException)
 */
public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
    // Nothing to do
}

/* (non-Javadoc)
 * @see java.net.ProxySelector#select(java.net.URI)
 */
public List select(URI uri) {
    ArrayList<Proxy> result = new ArrayList<Proxy>();

    if(uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https")){
        int uriPort = uri.getPort();

        // set default http and https ports if port is not given in URI
        if(uriPort<1){
            if(uri.getScheme().equalsIgnoreCase("http")){
                uriPort = 80;
            }
            else if(uri.getScheme().equalsIgnoreCase("http")){
                uriPort = 443;
            }
        }

        if(intranetAddress.getHost().equals(uri.getHost()) && intranetAddress.getPort()==uriPort){
            result.add(intranetProxy);
            System.out.println("Adding intranet Proxy!");
        }
        else if(extranetAddress.getHost().equals(uri.getHost()) && extranetAddress.getPort()==uriPort){
            result.add(extranetProxy);
            System.out.println("Adding extranet Proxy!");
        }
    }

    if(result.isEmpty()){
        List<Proxy> defaultResult = defaultProxySelector.select(uri);
        if(defaultResult!=null && !defaultResult.isEmpty()){
            result.addAll(defaultResult);
            System.out.println("Adding Proxis from default selector.");
        }
        else{
            result.add(directConnection);
            System.out.println("Adding direct connection, because requested URI does not match any Proxy");
        }
    }

    return result;
}

public void setIntranetProxy(String proxyAddress, int proxyPort){
    if(proxyAddress==null || proxyAddress.isEmpty()){
        intranetProxy = Proxy.NO_PROXY;
    }
    else{
        SocketAddress address = new InetSocketAddress(proxyAddress, proxyPort);
        intranetProxy = new Proxy(Proxy.Type.HTTP, address);
    }
}

public void setExtranetProxy(String proxyAddress, int proxyPort){
    if(proxyAddress==null || proxyAddress.isEmpty()){
        extranetProxy = Proxy.NO_PROXY;
    }
    else{
        SocketAddress address = new InetSocketAddress(proxyAddress, proxyPort);
        extranetProxy = new Proxy(Proxy.Type.HTTP, address);
    }
}

public void clearIntranetProxy(){
    intranetProxy = Proxy.NO_PROXY;
}

public void clearExtranetProxy(){
    extranetProxy = Proxy.NO_PROXY;
}

public void setIntranetAddress(String address) throws URISyntaxException{
    intranetAddress = new URI(address);
}

public void setExtranetAddress(String address) throws URISyntaxException{
    extranetAddress = new URI(address);
}