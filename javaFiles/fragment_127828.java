@Override
protected Injector getInjector() {
    return Guice.createInjector(
            new ServletModule() {
                @Override protected void configureServlets() {
                    serve("/index.html").with(IndexController.class);
                }
            },
            new ListModule());
}