@SuppressWarnings("requestfactory")
@ProxyForName("com.foobar.server.display.DDisplay")
public interface DDisplayProxy extends EntityProxy {

    String getTitle();
}