public MyApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/{projectName}/{wallName}", MyServerResource.class);

        return router;
    }
}