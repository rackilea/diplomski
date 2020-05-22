@Override
public void start(Future<Void> future) {
    Router router = Router.router(vertx);
    router.route().handler(CookieHandler.create());
    router.get("/set-cookie").handler(this::setCookieHandler);
}


public void setCookieHandler(RoutingContext context) {
    String name = "foo";
    String value = "bar";
    long age = 158132000l; //5 years in seconds
    Cookie cookie = Cookie.cookie(name,value);
    String path = "/"; //give any suitable path
    cookie.setPath(path);
    cookie.setMaxAge(age); //if this is not there, then a session cookie is set
    context.addCookie(cookie);

    context.response().setChunked(true);
    context.response().putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
    context.response().putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET");
    context.response().write("Cookie Stamped -> " + name + " : " +value);
    context.response().end();
}