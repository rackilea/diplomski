public class ViewApplication extends io.dropwizard.Application<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        environment.jersey().register(new ApplicationEventListener() {
            @Override
            public void onEvent(ApplicationEvent event) {
                if (event.getType() == ApplicationEvent.Type.INITIALIZATION_FINISHED) {
                    ServiceLocator serviceLocator = ((ServletContainer) environment.getJerseyServletContainer())
                            .getApplicationHandler().getServiceLocator();

                    ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {

                        @Override
                        protected void configure() {
                            bind(new Repository("test")).to(Repository.class);
                            bind(MyCommandInjected.class).to(MyCommandInjected.class);
                        }
                    });

                    MyCommandInjected service = serviceLocator.getService(MyCommandInjected.class);
                    MyCommandManual tmp = new MyCommandManual(serviceLocator);
                }
            }
            @Override
            public RequestEventListener onRequest(RequestEvent requestEvent) {
                return null;
            }
        });


    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        super.initialize(bootstrap);
    }

    public static void main(String[] args) throws Exception {
        new ViewApplication().run("server", "/home/artur/dev/repo/sandbox/src/main/resources/config/test.yaml");
    }

    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public static class HelloResource {

        @GET
        @Path("asd")
        public String test(String x) {
            return "Hello";
        }

    }

    public static class Repository {

        @Inject
        public Repository(String something) {
        }
    }

    public static class MyCommandInjected {

        @Inject
        public MyCommandInjected(final Repository repo) {
            System.out.println("Repo injected " + repo);
        }
    }

    public static class MyCommandManual {

        public MyCommandManual(final ServiceLocator sl) {
            Repository service = sl.getService(Repository.class);
            System.out.println("Repo found: " + service);
        }
    }

}