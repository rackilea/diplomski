public class MyRequestHandler implements HttpRequestHandler { 
private play.api.http.JavaCompatibleHttpRequestHandler adminRequestHandler;
private play.api.http.JavaCompatibleHttpRequestHandler webRequestHandler;

@Inject
public MyRequestHandler(web.Routes webRoutes, HttpErrorHandler httpErrorHandler,admin.Routes adminRoutes,
                        HttpConfiguration configuration, HttpFilters httpFilters,
                        JavaHandlerComponents components) {
    adminRequestHandler = new JavaCompatibleHttpRequestHandler(adminRoutes,httpErrorHandler
            ,configuration, httpFilters,components);
    webRequestHandler = new JavaCompatibleHttpRequestHandler(webRoutes,httpErrorHandler
            ,configuration, httpFilters,components);
}

 @Override
public HandlerForRequest handlerForRequest(Http.RequestHeader request) {
    Logger.info("Request ---> ["+ request.method()+"] "+request.host() + request.uri() );
    if("admin".equalsIgnoreCase(getSubDomain(request))){
        Tuple2<RequestHeader, Handler> result = adminRequestHandler.handlerForRequest(request._underlyingHeader());
        return new HandlerForRequest(new RequestHeaderImpl(result._1()), result._2());
    }else {
        Tuple2<RequestHeader, Handler> result = webRequestHandler.handlerForRequest(request._underlyingHeader());
        return new HandlerForRequest(new RequestHeaderImpl(result._1()), result._2());
    }
}