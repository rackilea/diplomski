public Restlet createInboundRoot() {
    Router router = new Router(getContext());
    (...)

    GaeAuthenticator guard= new GaeAuthenticator(getContext());
    guard.setNext(router);

    return guard;
}