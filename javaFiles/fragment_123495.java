@Override
public Restlet createInboundRoot() {
    Router router = new Router(getContext());
    router.attach("/attendance/faculty/{name}", FacultyServerResource.class);
    router.attach("/attendance/faculty/", FacultyListServerResource.class);
    return router;
}