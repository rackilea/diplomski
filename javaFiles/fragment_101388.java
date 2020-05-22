@Configuration
public class NettyReactiveWebServerConfig extends NettyReactiveWebServerFactory {
@Value("${server.context-path}")
private String contextPath;

@Override
public WebServer getWebServer(HttpHandler httpHandler) {
    Map<String, HttpHandler> handlerMap = new HashMap<>();
    handlerMap.put(contextPath, httpHandler);
    return super.getWebServer(new AppContextPathCompositeHandler(handlerMap));
}
}