public class AppContextPathCompositeHandler extends ContextPathCompositeHandler {

public AppContextPathCompositeHandler(Map<String, ? extends HttpHandler> handlerMap) {
    super(handlerMap);
}

@Override
public Mono<Void> handle(ServerHttpRequest request, ServerHttpResponse response) {
    if (HttpMethod.CONNECT.name().equals(request.getMethodValue())) {
        response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
        return response.setComplete();
    }

    return super.handle(request, response);
}
}