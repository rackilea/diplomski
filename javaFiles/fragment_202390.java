import java.net.*;
import java.util.*;

public class AlwaysProxySelector implements ProxySelector {
  private List<Proxy> proxies = Arrays.asList(new Proxy[] {
        new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080))
      });

  public List<Proxy> select(URI u) { return proxies; }
  public void connectFailed(URI u, SocketAddress a, IOException e) {}
}