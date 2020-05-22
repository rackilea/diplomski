public class RestletApplication extends SwaggerApplication {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/ping", MyServerResource.class);
        attachSwaggerSpecificationRestlet(router, "/docs");

        return router;
    }
}